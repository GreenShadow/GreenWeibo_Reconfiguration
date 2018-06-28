package com.greenshadow.greenweibo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.greenshadow.greenweibo.R;
import com.sina.weibo.sdk.auth.AccessTokenKeeper;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.auth.WbConnectErrorMessage;
import com.sina.weibo.sdk.auth.sso.SsoHandler;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class AuthActivity extends BaseActivity implements WbAuthListener {
    private SsoHandler mSsoHandler;

    @OnClick(R.id.btn_auth)
    void auth() {
        mSsoHandler.authorize(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        ButterKnife.bind(this);

        mSsoHandler = new SsoHandler(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // SSO 授权回调
        if (mSsoHandler != null) {
            mSsoHandler.authorizeCallBack(requestCode, resultCode, data);
        }
    }

    @Override
    public void onSuccess(Oauth2AccessToken token) {
        AccessTokenKeeper.writeAccessToken(this, token);
        toast(R.string.auth_success);
    }

    @Override
    public void cancel() {
        toast(R.string.auth_cancel);
    }

    @Override
    public void onFailure(WbConnectErrorMessage errorMessage) {
        loge(errorMessage.getErrorCode()
        );
        loge(errorMessage.getErrorMessage());
        toast(R.string.auth_error);
    }
}

package com.greenshadow.greenweibo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.greenshadow.greenweibo.R;
import com.greenshadow.greenweibo.activity.base.BaseActivity;
import com.sina.weibo.sdk.auth.AccessTokenKeeper;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.auth.WbConnectErrorMessage;
import com.sina.weibo.sdk.auth.sso.SsoHandler;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class AuthActivity extends BaseActivity implements WbAuthListener {
    private static final String TAG = AuthActivity.class.getSimpleName();
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
        loge(TAG, errorMessage.getErrorCode());
        loge(TAG, errorMessage.getErrorMessage());
        toast(R.string.auth_error);
    }
}

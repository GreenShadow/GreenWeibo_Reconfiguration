package com.greenshadow.greenweibo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.BaseAdapter;

import com.greenshadow.greenweibo.R;
import com.sina.weibo.sdk.auth.AccessTokenKeeper;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;

public class SplashActivity extends BaseActivity {
    private static final int AUTH = 0;
    private static final int HOME = 1;

    private static final long SPLASH_DELAY = 500;

    private Handler mHandler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(Message msg) {
            Intent i;
            switch (msg.what) {
                case AUTH:
                    i = new Intent(SplashActivity.this, AuthActivity.class);
                    break;
                case HOME:
                    i = new Intent(SplashActivity.this, HomeActivity.class);
                    break;
                default:
                    i = null;
            }
            if (i != null) {
                startActivity(i);
                finish();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Oauth2AccessToken mAccessToken = AccessTokenKeeper.readAccessToken(getApplicationContext());
        if (mAccessToken.isSessionValid()) {
            mHandler.sendEmptyMessageDelayed(HOME, SPLASH_DELAY);
        } else {
            mHandler.sendEmptyMessageDelayed(AUTH, SPLASH_DELAY);
        }
    }
}

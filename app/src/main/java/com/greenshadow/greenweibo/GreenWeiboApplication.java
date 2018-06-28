package com.greenshadow.greenweibo;

import android.app.Application;

import com.greenshadow.greenweibo.weibosdk.Constants;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;

public class GreenWeiboApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        AuthInfo authInfo = new AuthInfo(this,
                Constants.APP_KEY, Constants.REDIRECT_URL, Constants.SCOPE);
        WbSdk.install(this, authInfo);
    }
}

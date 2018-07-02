package com.greenshadow.greenweibo;

import android.app.Application;

import com.greenshadow.greenweibo.weibosdk.ApplicationConstants;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;

public class GreenWeiboApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        AuthInfo authInfo = new AuthInfo(this,
                ApplicationConstants.APP_KEY, ApplicationConstants.REDIRECT_URL, ApplicationConstants.SCOPE);
        WbSdk.install(this, authInfo);
    }
}

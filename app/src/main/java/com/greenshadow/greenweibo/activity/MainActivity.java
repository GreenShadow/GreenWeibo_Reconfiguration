package com.greenshadow.greenweibo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.widget.TextView;

import com.greenshadow.greenweibo.R;
import com.greenshadow.greenweibo.activity.base.ToolBarBaseActivity;
import com.greenshadow.greenweibo.weibosdk.ApplicationConstants;
import com.sina.weibo.sdk.auth.AccessTokenKeeper;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.AsyncWeiboRunner;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.net.WeiboParameters;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends ToolBarBaseActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.drawer_home) DrawerLayout mDrawer;
    @BindView(R.id.test_result) TextView testResult;

    @OnClick(R.id.test)
    void test() {
        WeiboParameters parameters = new WeiboParameters(ApplicationConstants.APP_KEY);
        log("asdasd", AccessTokenKeeper.readAccessToken(getApplicationContext()).getToken());

        parameters.put("access_token", AccessTokenKeeper.readAccessToken(getApplicationContext()).getToken());
        parameters.put("since_id", 0);
        parameters.put("max_id", 0);
        parameters.put("count", 1);
        parameters.put("page", 1);
        parameters.put("base_app", 0);
        parameters.put("feature", 0);
        parameters.put("trim_user", 0);

        new AsyncWeiboRunner(this).requestAsync(
                "https://api.weibo.com/2/statuses/friends_timeline.json",
                parameters,
                "GET",
                new RequestListener() {
                    @Override
                    public void onComplete(String s) {
                        log("asdasd", "complete, " + s);
                        testResult.setText(s);
                    }

                    @Override
                    public void onWeiboException(WeiboException e) {
                        loge("asdasd", "error, " + e.toString());
                    }
                });
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setupToolBar() {
        setSupportActionBar(getToolBar());

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawer, getToolBar(), 0, 0);
        toggle.syncState();
        mDrawer.addDrawerListener(toggle);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar == null) {
            loge(TAG, "setupToolBar : ActionBar is null!");
            return;
        }

        actionBar.setDisplayShowHomeEnabled(true);
    }

    @Override
    protected void onStart() {
        super.onStart();
//        getSupportFragmentManager().beginTransaction().
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}

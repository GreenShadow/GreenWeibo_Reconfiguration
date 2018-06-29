package com.greenshadow.greenweibo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;

import com.greenshadow.greenweibo.R;
import com.greenshadow.greenweibo.activity.base.ToolBarBaseActivity;

import butterknife.BindView;

public class MainActivity extends ToolBarBaseActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.drawer_home) DrawerLayout mDrawer;

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
}

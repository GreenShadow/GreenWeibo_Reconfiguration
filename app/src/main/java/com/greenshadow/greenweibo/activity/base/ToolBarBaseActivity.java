package com.greenshadow.greenweibo.activity.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.greenshadow.greenweibo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class ToolBarBaseActivity extends BaseActivity {
    private static final String TAG = ToolBarBaseActivity.class.getSimpleName();

    @BindView(R.id.tool_bar)
    Toolbar mToolBar;

    /**
     * {@link #setContentView method should be called befor the super method.}
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        if (mToolBar != null) {
            setupToolBar();
        } else {
            loge(TAG, emptyViewErrorMsg("<init>"));
        }
    }

    @Nullable
    protected Toolbar getToolBar() {
        if (mToolBar == null) {
            loge(TAG, emptyViewErrorMsg("getToolBar"));
        }
        return mToolBar;
    }

    protected abstract void setupToolBar();

    private String emptyViewErrorMsg(String name) {
        return name + " : Can not find res id \"R.id.tool_bar\", please check your layout files!";
    }
}

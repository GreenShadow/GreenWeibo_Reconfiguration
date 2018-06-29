package com.greenshadow.greenweibo.activity.base;

import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

public abstract class BaseActivity extends AppCompatActivity {
    private static String LOG_TAG = "GreenWeibo";

    private Toast mToast = null;

    protected void log(String tag, String msg) {
        Log.d(LOG_TAG, "[" + tag + "]" + msg);
    }

    protected void loge(String tag, String msg) {
        Log.e(LOG_TAG, "[" + tag + "]" + msg);
    }

    protected void printStack(String tag, String msg) {
        Log.wtf(LOG_TAG, "[" + tag + "]" + msg, new Throwable());
    }

    protected void toast(CharSequence msg) {
        if (mToast == null) {
            mToast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
            mToast.show();
        } else {
            mToast.setText(msg);
        }
    }

    protected void toast(@StringRes int stringId) {
        if (mToast == null) {
            mToast = Toast.makeText(this, stringId, Toast.LENGTH_LONG);
            mToast.show();
        } else {
            mToast.setText(stringId);
        }
    }
}

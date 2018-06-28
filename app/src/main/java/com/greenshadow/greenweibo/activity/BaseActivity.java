package com.greenshadow.greenweibo.activity;

import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

public abstract class BaseActivity extends AppCompatActivity {
    private static String LOG_TAG = "GreenWeibo";

    private Toast mToast = null;

    protected void log(String msg) {
        Log.d(LOG_TAG, msg);
    }

    protected void loge(String msg) {
        Log.e(LOG_TAG, msg);
    }

    protected void printStack() {
        Log.wtf(LOG_TAG, new Exception());
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

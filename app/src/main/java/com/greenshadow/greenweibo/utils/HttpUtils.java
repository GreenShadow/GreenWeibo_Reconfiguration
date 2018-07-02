package com.greenshadow.greenweibo.utils;

import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpUtils {
    private static final String TAG = HttpUtils.class.getSimpleName();

    public static void get() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().get().url("https://www.baidu.com").build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "get - failure", e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d(TAG, response.toString());
            }
        });
    }
}

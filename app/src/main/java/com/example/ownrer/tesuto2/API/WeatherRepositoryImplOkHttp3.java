package com.example.ownrer.tesuto2.API;

/**
 * Created by  on 2018/04/28.
 */
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.example.ownrer.tesuto2.Entity.Weather;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
public class WeatherRepositoryImplOkHttp3 implements WeatherRepository {
    public static final String TAG = WeatherRepositoryImplOkHttp3.class.getSimpleName();

    private Handler handler = new Handler();

    @Override
    public void getWeather() {
        final Request request = new Request.Builder()
                // URLを生成
                .url(uri.toString())
                .get()
                .build();
        // クライアントオブジェクトを作成する
        final OkHttpClient client = new OkHttpClient();
        // 新しいリクエストを行う
        client.newCall(request).enqueue(new Callback() {
            // 通信が成功した時
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                // 通信結果をログに出力する
                final String responseBody = response.body().string();
                Log.d(TAG, "result: " + responseBody);
                final Weather weather = new Gson().fromJson(responseBody, Weather.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }

            // 通信が失敗した時
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }
        });
    }
}
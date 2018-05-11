package com.example.ownrer.tesuto2;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ownrer.tesuto2.API.WeatherRepository;

import com.example.ownrer.tesuto2.API.WeatherRepositoryImplOkHttp3;
import com.example.ownrer.tesuto2.Entity.Weather;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
     * 同期通信でPOSTリクエストをするサンプルコード
     *
     */

    public class HttpTestActivity extends AppCompatActivity implements WeatherRepository {


        private Button btn = null;
        private TextView tv = null;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_http_test);

            btn = (Button)findViewById(R.id.btn1);
            tv = (TextView)findViewById(R.id.tv1);

            btn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    // ボタン押下時
                    if( view == btn )
                    {


                        getWeather();

                    }

                }
            });
        }



    public static final String TAG = WeatherRepositoryImplOkHttp3.class.getSimpleName();

    private Handler handler = new Handler();

    @Override
    public void getWeather() {
        RequestBody formBody = new FormBody.Builder()
                .add("password", "password")
                .add("mail_adress", "mail@mail.com")
                .add("name", "nanashinogonbei")
                .build();


        final Request request = new Request.Builder()
                // URLを生成
                .url(uri.toString())
                .post(formBody)
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
                Log.d(TAG, "result: " + String.valueOf(responseBody));
                final Weather weather = new Gson().fromJson(responseBody, Weather.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG,"成功");
                        tv.setText(String.valueOf(responseBody));




                    }

                });
            }

            // 通信が失敗した時
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG,"ネットワークエラー");

                    }
                });
            }
        });
    }



}

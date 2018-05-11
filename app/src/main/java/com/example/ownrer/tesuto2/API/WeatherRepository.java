package com.example.ownrer.tesuto2.API;

/**
 * Created by  on 2018/04/28.
 */

import android.net.Uri;
import android.os.Handler;
import android.os.Message;

import com.example.ownrer.tesuto2.Entity.Weather;

/**
 * HTTP通信のPOSTタスク完了時に，通信の成否に応じて，受信した通信内容をUI上で取り扱うための抽象クラス。
 *
 */

public interface WeatherRepository {
    // URL Const Vals
    String SCHEME = "http";
    String AUTHORITY = "yusawamu.sakura.ne.jp" +
            "" +
            "" +
            "" +
            "";
    String PATH = "/php-sample/customer/regist";
    // URI
    Uri uri = new Uri.Builder()
            .scheme(SCHEME)
            .authority(AUTHORITY)
            .path(PATH)
            .appendQueryParameter("city", "130010")
            .build();

    void getWeather();

    interface RequestCallback {
        // 成功時のCallback
        void success(Weather weather);

        // 失敗次のCallback
        void error(Throwable throwable);
    }

}
package com.example.ownrer.tesuto2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView rogin;
    TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ログインボタン押下時に処理を追加
        rogin = (Button) findViewById(R.id.rogin);
        rogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        // 新規登録
        register = (Button) findViewById(R.id.register);
        // 新規登録ボタンを押下した場合新規登録機能を実施
        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, UserRegisterActivity.class);
//                startActivity(intent);
                Intent intent = new Intent(MainActivity.this, HttpTestActivity.class);
                startActivity(intent);
            }
        });
    }
}

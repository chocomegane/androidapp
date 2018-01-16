package com.example.ownrer.tesuto2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button rogin;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ログインボタン
        rogin =(Button)findViewById(R.id.rogin);
        rogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        // 新規登録
        register =(Button)findViewById(R.id.register);
        // 新規登録ボタンを押下した場合新規登録機能を実施
        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ImgActivity.class);
                startActivity(intent);

            }
        });

    }
}

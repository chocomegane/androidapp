package com.example.ownrer.tesuto2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        TextView name = (TextView) findViewById(R.id.username_text);
        // TODO 名前　メールアドレス　パスワードを登録する
        String name_text = name.getText().toString();
        Button regist_button = (Button) findViewById(R.id.regist);
        regist_button.setOnClickListener( new View.OnClickListener(){public void onClick(View v) {
                // TODO APIと連携今はモックとして作成
                Intent intent = new Intent(UserRegisterActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}

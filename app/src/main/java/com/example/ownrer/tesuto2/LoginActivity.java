package com.example.ownrer.tesuto2;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    TextView email;
    TextView password;
    String password_text;
    String email_text;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login_button = (Button)findViewById(R.id.login);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        password_text = password.getText().toString();
        email_text = email.getText().toString();

        login_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // TODO フラグメントを使用してローディング及びダブルサブミット対策を行いたい
//                LodingFragment fragment = new LodingFragment();
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                transaction.add(R.id.container, fragment);
//                transaction.commit();
                String password_text = password.getText().toString();
                Boolean password_result =  passwordValidate(password_text);
                String email_text = email.getText().toString();
                Boolean email_result =  emailValidate(email_text);
                if(email_result) {
                    Toast.makeText(getApplicationContext(), "メールアドレスを正しく入力してください", Toast.LENGTH_SHORT).show();
                }else if(password_result) {
                    Toast.makeText(getApplicationContext(),"パスワードは英数字を使用してください", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    /**
     *パスワードのバリデーションを実施する
     * @param password
     * @return
     */
    public Boolean passwordValidate(String password ){

        if(password.equals("") || password.equals(null)){
            Toast.makeText(getApplicationContext(),"@@@a@@",Toast.LENGTH_SHORT).show();
            return false ;
        }
        //判定するパターンを生成
        String pattan = "^[0-9a-zA-Z]+$";
        if(password.matches(pattan)){
            return true;
        }
        return false;
    }
    /**
     *　メールアドレスのバリデーション実施する
     * @param email
     * @return
     */
    public Boolean emailValidate(String email ){

        if(email.equals("") || email.equals(null)){
            return false ;
        }
        //判定するパターンを生成
        String pattan = "/^([a-zA-Z0-9])+([a-zA-Z0-9\\._-])*@([a-zA-Z0-9_-])+([a-zA-Z0-9\\._-]+)+$/";
        if(email.matches(pattan)){
            return true;
        }
        return false;
    }

}

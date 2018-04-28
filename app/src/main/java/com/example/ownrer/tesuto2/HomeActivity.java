package com.example.ownrer.tesuto2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements RatioMoneyFragment.raitoMoneyListener
                                                                ,MoneyExpenseFragment.moneyExpenseListener
                                                                ,RegistMoneyFragment.registMoneyListener{

    RatioMoneyFragment fragment_ratio = new RatioMoneyFragment();
    MoneyExpenseFragment fragment_use_expense = new MoneyExpenseFragment();
    RegistMoneyFragment fragment_money_regist = new RegistMoneyFragment();
    LinearLayout meny;

    /**
     * 画面生成
     *
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // TODO ローデイングを実装したい
//        LodingFragment fragment = new LodingFragment();
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.add(R.id.container, fragment);
//        transaction.commit();
//        createPieChart();
        Button money_regist_button = (Button) findViewById(R.id.money_regist);
        Button ratio_button = (Button)findViewById(R.id.ratio);
        Button month_used_button = (Button)findViewById(R.id.month_used_money);
//        Button ratio_button = (Button)findViewById(R.id.ratio);
//        Button ratio_button = (Button)findViewById(R.id.ratio);
        meny = (LinearLayout) findViewById(R.id.many) ;
        ratio_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                meny.setVisibility(View.GONE);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.container, fragment_ratio);
                transaction.commit();
            }
        });
        // メニューの出費棒グラフを表示する際の処理
        month_used_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                meny.setVisibility(view.GONE);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction().add(R.id.container,fragment_use_expense);
                transaction.commit();
            }
        });
        // 今月の給及び目標値を設定する画面を表示
        money_regist_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                meny.setVisibility(view.GONE);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction().add(R.id.container,fragment_money_regist);
                transaction.commit();
            }
        });

    }


    /**
     * メニューで選択された給与使用状況の画面を閉じメニューを再表示する
     *
     */
    @Override
    public void deleteRatioMoneyView(){
        // 給与使用率画面を非表示にする
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction().remove(fragment_ratio);
        transaction.commit();
        meny.setVisibility(View.VISIBLE);

    }

    /**
     *
     *
     */
    @Override
    public void deleteMoneyExpenseView(){
        // 月別の出費表示画面を非表示にする
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction().remove(fragment_use_expense);
        transaction.commit();
        meny.setVisibility(View.VISIBLE);

    }

    /**
     *
     *
     */
    @Override
    public void deleteRegistMoneyView(){
        // 登録画面を非表示にする
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction().remove(fragment_money_regist);
        transaction.commit();
        meny.setVisibility(View.VISIBLE);

    }

}

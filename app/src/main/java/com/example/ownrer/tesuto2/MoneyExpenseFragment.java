package com.example.ownrer.tesuto2;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * 月別の出費をグラフに月別に記載
 */
public class MoneyExpenseFragment extends Fragment {

    private moneyExpenseListener Listener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_money_expense, container, false);
        createBarChart(view);
        Button back_button = (Button)view.findViewById(R.id.back);

        //　メニュー画面に戻る
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Listener.deleteMoneyExpenseView();
            }
        });


        return view ;
    }

    private void createBarChart(View view) {
        BarChart barChart = (BarChart) view.findViewById(R.id.bar_chart);
        barChart.setDescription("出費");

        barChart.getAxisRight().setEnabled(false);
        barChart.getAxisLeft().setEnabled(true);
        barChart.setDrawGridBackground(false);
        barChart.setDrawBarShadow(false);
        barChart.setEnabled(false);

        barChart.setTouchEnabled(true);
        barChart.setPinchZoom(false);
        barChart.setDoubleTapToZoomEnabled(false);

        barChart.setHighlightEnabled(true);
        barChart.setDrawHighlightArrow(true);
        barChart.setHighlightEnabled(true);

        barChart.setScaleEnabled(true);

        barChart.getLegend().setEnabled(true);

        //X軸周り
        XAxis xAxis = barChart.getXAxis();
        xAxis.setDrawLabels(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setSpaceBetweenLabels(0);

        YAxis leftAxis = barChart.getAxisLeft();
        leftAxis.setDrawGridLines(false);

        //　y軸固定　ー＞　固定すると最大値が大きい場合辛くなる
//        leftAxis.setAxisMaxValue(150f);
//        leftAxis.setAxisMinValue(0f);

        barChart.setData(createBarChartData());

        barChart.invalidate();
        // アニメーション
        barChart.animateY(2000, Easing.EasingOption.EaseInBack);
    }

    // BarChartの設定
    private BarData createBarChartData() {
        ArrayList<BarDataSet> barDataSets = new ArrayList<>();

        // X軸
        ArrayList<String> xValues = new ArrayList<>();
        xValues.add("1月");
        xValues.add("2月");
        xValues.add("3月");
        xValues.add("4月");
        xValues.add("5月");
        xValues.add("6月");
        xValues.add("7月");
        xValues.add("8月");
        xValues.add("9月");
        xValues.add("10月");
        xValues.add("11月");
        xValues.add("12月");

        // 出費をリストに格納し引数に渡す
        ArrayList<BarEntry> valuesA = new ArrayList<>();
        // TODO 仮の値動的にする
        valuesA.add(new BarEntry(100, 0));
        valuesA.add(new BarEntry(200, 1));
        valuesA.add(new BarEntry(300, 2));
        valuesA.add(new BarEntry(400, 3));
        valuesA.add(new BarEntry(500, 4));
        valuesA.add(new BarEntry(600, 5));

        BarDataSet valuesADataSet = new BarDataSet(valuesA, "A");
        valuesADataSet.setColor(ColorTemplate.COLORFUL_COLORS[3]);

        barDataSets.add(valuesADataSet);

        // valueB
//        ArrayList<BarEntry> valuesB = new ArrayList<>();
//        valuesB.add(new BarEntry(200, 0));
//        valuesB.add(new BarEntry(300, 1));
//        valuesB.add(new BarEntry(400, 2));
//        valuesB.add(new BarEntry(500, 3));
//        valuesB.add(new BarEntry(600, 4));
//        valuesB.add(new BarEntry(700, 5));

//        BarDataSet valuesBDataSet = new BarDataSet(valuesB, "B");
//        valuesBDataSet.setColor(ColorTemplate.COLORFUL_COLORS[4]);

//        barDataSets.add(valuesBDataSet);

        BarData barData = new BarData(xValues, barDataSets);
        return barData;
    }

    public interface moneyExpenseListener{
        public void deleteMoneyExpenseView();

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof moneyExpenseListener == false) {
            throw new ClassCastException("activity が OnOkBtnClickListener を実装していません.");
        }

        Listener = ((moneyExpenseListener) activity);
    }



}

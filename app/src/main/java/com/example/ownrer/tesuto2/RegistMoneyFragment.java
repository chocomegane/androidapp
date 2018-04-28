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

public class RegistMoneyFragment extends Fragment {

    private registMoneyListener Listener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_regist_money, container, false);

        Button regist_button = (Button)view.findViewById(R.id.register);
        regist_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO API連携したい
                Listener.deleteRegistMoneyView();
            }
        });
        Button back_button = (Button)view.findViewById(R.id.back);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Listener.deleteRegistMoneyView();
            }
        });

        return view ;
    }

    public interface registMoneyListener{
        public void deleteRegistMoneyView();
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof registMoneyListener == false) {
            throw new ClassCastException("activity が OnOkBtnClickListener を実装していません.");
        }

        Listener = ((registMoneyListener) activity);
    }

}

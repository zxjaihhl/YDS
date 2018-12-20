package com.zxjaihhl.yds.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Toast;


import com.zxjaihhl.yds.R;
import com.zxjaihhl.yds.view.WheelView;

import java.util.Arrays;

import butterknife.ButterKnife;


/**
 * Created by Administrator on 2017/9/13.
 * 描述：
 */

public class LEDFragment extends Fragment implements View.OnClickListener {
    private static final String[] PLANETS = new String[]{"颜色一", "颜色二", "颜色三", "颜色四"};
    private CheckBox select_one, select_two, select_three, select_four;
    private WheelView wva;
    private ImageButton btn_light;
    private int LIGHT_KEY, LIGHT_KEY_TWO = 1001, SWITCH_KEY = 2001;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fregment_led_layout, null);
        ButterKnife.bind(getActivity());
        findView(view);
        wva.setVisibility(View.GONE);
        select_one.setChecked(false);
        select_two.setChecked(false);
        select_three.setChecked(false);
        select_four.setChecked(false);
        setListener();
        return view;
    }

    private void setListener() {
        select_one.setOnClickListener(this);
        select_two.setOnClickListener(this);
        select_three.setOnClickListener(this);
        select_four.setOnClickListener(this);
        btn_light.setOnClickListener(this);
    }


    private void findView(View view) {
        btn_light = (ImageButton) view.findViewById(R.id.btn_light);
        select_one = (CheckBox) view.findViewById(R.id.select_one);
        select_two = (CheckBox) view.findViewById(R.id.select_two);
        select_three = (CheckBox) view.findViewById(R.id.select_three);
        select_four = (CheckBox) view.findViewById(R.id.select_four);
        wva = (WheelView) view.findViewById(R.id.main_wv);
        //选择颜色
        wva.setOffset(1);
        wva.setItems(Arrays.asList(PLANETS));


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.select_two:
                if (select_two.isChecked()) {
                    LIGHT_KEY = 1000;
                    SWITCH_KEY = 2001;
                    select_one.setChecked(false);
                    select_three.setChecked(false);
                    select_four.setChecked(false);
                    wva.setVisibility(View.VISIBLE);
                    wva.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
                        @Override
                        public void onSelected(int selectedIndex, String item) {
                            //选择点击后的操作
                            if (selectedIndex == 1) {
                                LIGHT_KEY_TWO = 1001;
                                SWITCH_KEY = 2001;
                            } else if (selectedIndex == 2) {
                                LIGHT_KEY_TWO = 1002;
                                SWITCH_KEY = 2001;
                            } else if (selectedIndex == 3) {
                                LIGHT_KEY_TWO = 1003;
                                SWITCH_KEY = 2001;
                            } else if (selectedIndex == 4) {
                                LIGHT_KEY_TWO = 1004;
                                SWITCH_KEY = 2001;
                            }
                        }
                    });

                } else if (!select_two.isChecked()) {
                    wva.setVisibility(View.GONE);
                    LIGHT_KEY = 1000;

                }
                break;
            case R.id.select_one:
                if (select_one.isChecked()) {
                    select_two.setChecked(false);
                    select_three.setChecked(false);
                    select_four.setChecked(false);
                    wva.setVisibility(View.GONE);

                    LIGHT_KEY = 1005;
                    SWITCH_KEY = 2001;
                } else if (!select_one.isChecked()) {
                    LIGHT_KEY = 1000;

                }
                break;
            case R.id.select_three:
                if (select_three.isChecked()) {
                    select_two.setChecked(false);
                    select_one.setChecked(false);
                    select_four.setChecked(false);
                    wva.setVisibility(View.GONE);
                    LIGHT_KEY = 1006;
                    SWITCH_KEY = 2001;
                } else if (!select_three.isChecked()) {
                    LIGHT_KEY = 1000;

                }
                break;
            case R.id.select_four:
                if (select_four.isChecked()) {
                    select_two.setChecked(false);
                    select_one.setChecked(false);
                    select_three.setChecked(false);
                    wva.setVisibility(View.GONE);
                    LIGHT_KEY = 1007;
                    SWITCH_KEY = 2001;
                } else if (!select_four.isChecked()) {
                    LIGHT_KEY = 1000;

                }
                break;
            case R.id.btn_light:
                if (LIGHT_KEY == 1005 & SWITCH_KEY == 2001) {
                    Toast.makeText(getActivity(), "打开呼吸灯", Toast.LENGTH_SHORT).show();
                    SWITCH_KEY = 2002;
                } else if (LIGHT_KEY == 1006 & SWITCH_KEY == 2001) {
                    Toast.makeText(getActivity(), "打开七彩灯", Toast.LENGTH_SHORT).show();
                    SWITCH_KEY = 2002;
                } else if (LIGHT_KEY == 1007 & SWITCH_KEY == 2001) {
                    Toast.makeText(getActivity(), "打开白灯", Toast.LENGTH_SHORT).show();
                    SWITCH_KEY = 2002;
                } else if (select_two.isChecked() & LIGHT_KEY_TWO == 1001 & SWITCH_KEY == 2001) {
                    Toast.makeText(getActivity(), "打开颜色一", Toast.LENGTH_SHORT).show();
                    SWITCH_KEY = 2002;
                } else if (select_two.isChecked() & LIGHT_KEY_TWO == 1002 & SWITCH_KEY == 2001) {
                    Toast.makeText(getActivity(), "打开颜色二", Toast.LENGTH_SHORT).show();
                    SWITCH_KEY = 2002;
                } else if (select_two.isChecked() & LIGHT_KEY_TWO == 1003 & SWITCH_KEY == 2001) {
                    Toast.makeText(getActivity(), "打开颜色三", Toast.LENGTH_SHORT).show();
                    SWITCH_KEY = 2002;
                } else if (select_two.isChecked() & LIGHT_KEY_TWO == 1004 & SWITCH_KEY == 2001) {
                    Toast.makeText(getActivity(), "打开颜色四", Toast.LENGTH_SHORT).show();
                    SWITCH_KEY = 2002;
                } else if (SWITCH_KEY == 2002) {
                    Toast.makeText(getActivity(), "关灯", Toast.LENGTH_SHORT).show();
                    SWITCH_KEY = 2001;
                } else if (!select_one.isChecked() & !select_two.isChecked() & !select_three.isChecked() & !select_four.isChecked()) {
                    Toast.makeText(getActivity(), "关灯", Toast.LENGTH_SHORT).show();
                    SWITCH_KEY = 2001;
                }
                break;
        }
    }


}


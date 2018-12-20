package com.zxjaihhl.yds.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zxjaihhl.yds.R;
import com.zxjaihhl.yds.utils.SharedUtils;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/9/13.
 * 描述：
 */

public class BatteryFragment extends Fragment {
    private TextView tv_battery_pc;
    private int battery_pc;
    private int battery;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fregment_battery_layout, null);
        ButterKnife.bind(getActivity());
        findView(view);
        return view;
    }

    private void findView(View view) {
        tv_battery_pc= (TextView) view.findViewById(R.id.tv_battery_pc);
        battery_pc=100;
        tv_battery_pc.setText(battery_pc + "%");
        getBattery();



    }

    private void getBattery() {
        if(battery_pc>0&battery_pc<=12){
            battery=1;

        }else if(battery_pc>12&battery_pc<=25){
            battery=2;

        }else if(battery_pc>25&battery_pc<=37){
            battery=3;

        }else if(battery_pc>37&battery_pc<=50){
            battery=4;

        }else if(battery_pc>50&battery_pc<=62) {
            battery = 5;
        }else if(battery_pc>62&battery_pc<=75) {
            battery = 6;
        }else if(battery_pc>75&battery_pc<=87) {
            battery = 7;
        }else if(battery_pc==0) {
            battery = 0;
        }else if(battery_pc==100) {
            battery = 8;
        }

        SharedUtils.putInt(getActivity(),"battery_pc",battery);

    }


}

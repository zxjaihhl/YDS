package com.zxjaihhl.yds.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zxjaihhl.yds.R;
import com.zxjaihhl.yds.utils.UtilTools;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/9/13.
 * 描述：
 */

public class CheckFragment extends Fragment implements View.OnClickListener {
    private TextView tv_check_one, tv_check_two, tv_check_three, tv_check_four, tv_check_five, tv_check_six;
    private int CHECK0NE = 1001,CHECKTOW=2001,CHECKTHREE=3001,CHECKFOUR=4001,CHECKFIVE=5001,CHECKSIX=6001;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fregment_check_layout, null);
        ButterKnife.bind(getActivity());
        findView(view);

        return view;
    }

    private void findView(View view) {
        tv_check_one = (TextView) view.findViewById(R.id.tv_check_one);
        tv_check_two = (TextView) view.findViewById(R.id.tv_check_two);
        tv_check_three = (TextView) view.findViewById(R.id.tv_check_three);
        tv_check_four = (TextView) view.findViewById(R.id.tv_check_four);
        tv_check_five = (TextView) view.findViewById(R.id.tv_check_five);
        tv_check_six = (TextView) view.findViewById(R.id.tv_check_six);
//        UtilTools.setlFont(getActivity(),tv_check_one);
//        UtilTools.setlFont(getActivity(),tv_check_two);
//        UtilTools.setlFont(getActivity(),tv_check_three);
//        UtilTools.setlFont(getActivity(),tv_check_four);
//        UtilTools.setlFont(getActivity(),tv_check_five);
//        UtilTools.setlFont(getActivity(),tv_check_six);



        tv_check_one.setOnClickListener(this);
        tv_check_two.setOnClickListener(this);
        tv_check_three.setOnClickListener(this);
        tv_check_four.setOnClickListener(this);
        tv_check_five.setOnClickListener(this);
        tv_check_six.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_check_one:
                if (CHECK0NE == 1001) {
                    tv_check_one.setText("故障");
                    tv_check_one.setTextColor(this.getResources().getColor(R.color.color_red));
                    CHECK0NE = 1002;
                } else if (CHECK0NE == 1002) {
                    tv_check_one.setText("正常");
                    tv_check_one.setTextColor(this.getResources().getColor(R.color.color_white));
                    CHECK0NE = 1001;

                }

                break;
            case R.id.tv_check_two:
                if (CHECKTOW == 2001) {
                    tv_check_two.setText("故障");
                    tv_check_two.setTextColor(this.getResources().getColor(R.color.color_red));
                    CHECKTOW = 2002;
                } else if (CHECKTOW == 2002) {
                    tv_check_two.setText("正常");
                    tv_check_two.setTextColor(this.getResources().getColor(R.color.color_white));
                    CHECKTOW = 2001;

                }
                break;
            case R.id.tv_check_three:
                if (CHECKTHREE == 3001) {
                    tv_check_three.setText("故障");
                    tv_check_three.setTextColor(this.getResources().getColor(R.color.color_red));
                    CHECKTHREE = 3002;
                } else if (CHECKTHREE == 3002) {
                    tv_check_three.setText("正常");
                    tv_check_three.setTextColor(this.getResources().getColor(R.color.color_white));
                    CHECKTHREE = 3001;

                }
                break;
            case R.id.tv_check_four:
                if (CHECKFOUR == 4001) {
                    tv_check_four.setText("故障");
                    tv_check_four.setTextColor(this.getResources().getColor(R.color.color_red));
                    CHECKFOUR = 4002;
                } else if (CHECKFOUR == 4002) {
                    tv_check_four.setText("正常");
                    tv_check_four.setTextColor(this.getResources().getColor(R.color.color_white));
                    CHECKFOUR = 4001;

                }
                break;
            case R.id.tv_check_five:
                if (CHECKFIVE == 5001) {
                    tv_check_five.setText("故障");
                    tv_check_five.setTextColor(this.getResources().getColor(R.color.color_red));
                    CHECKFIVE = 5002;
                } else if (CHECKFIVE == 5002) {
                    tv_check_five.setText("正常");
                    tv_check_five.setTextColor(this.getResources().getColor(R.color.color_white));
                    CHECKFIVE = 5001;

                }
                break;
            case R.id.tv_check_six:
                if (CHECKSIX == 6001) {
                    tv_check_six.setText("故障");
                    tv_check_six.setTextColor(this.getResources().getColor(R.color.color_red));
                    CHECKSIX = 6002;
                } else if (CHECKSIX == 6002) {
                    tv_check_six.setText("正常");
                    tv_check_six.setTextColor(this.getResources().getColor(R.color.color_white));
                    CHECKSIX = 6001;

                }
                break;
        }
    }
}

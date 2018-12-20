package com.zxjaihhl.yds.fragment;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.zxjaihhl.yds.R;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/9/13.
 * 描述：
 */

public class SpeedFragment extends Fragment implements View.OnClickListener {
    private ImageView iv_speed_line,iv_speed_line_four;
    private Animation rotate,rotate_two;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fregment_speed_layout, null);
        ButterKnife.bind(getActivity());
        getAnimation();
        findView(view);
        return view;
    }

    private void getAnimation() {
        rotate = AnimationUtils.loadAnimation(getActivity(), R.anim.rotate);//创建动画
        rotate.setInterpolator(new LinearInterpolator());//设置为线性旋转
        rotate.setFillAfter(!rotate.getFillAfter());
        rotate_two = AnimationUtils.loadAnimation(getActivity(), R.anim.rotate);//创建动画
        rotate_two.setInterpolator(new LinearInterpolator());//设置为线性旋转
        rotate_two.setFillAfter(!rotate_two.getFillAfter());
    }

    private void findView(View view) {
        iv_speed_line= (ImageView) view.findViewById(R.id.iv_speed_line);
        iv_speed_line.setOnClickListener(this);
        iv_speed_line_four= (ImageView) view.findViewById(R.id.iv_speed_line_four);
        iv_speed_line_four.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_speed_line:
                iv_speed_line.startAnimation(rotate);
                break;
            case R.id.iv_speed_line_four:
                iv_speed_line_four.startAnimation(rotate_two);
                break;
        }

    }
}

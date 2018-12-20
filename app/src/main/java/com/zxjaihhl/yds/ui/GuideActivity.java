package com.zxjaihhl.yds.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.zxjaihhl.yds.MainActivity;
import com.zxjaihhl.yds.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/13.
 * 描述：
 */

public class GuideActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager mViewPager;
    //容器
    private List<View> mList=new ArrayList<>();
    private View view1,view2,view3;
    //小圆点
    private ImageView point1,point2,point3;
    //进入按钮
    private Button btn_start;
    //跳过按钮
    private ImageView img_black;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_guide);
        initView();
    }
    //初始化View
    private void initView() {

        img_black= (ImageView) findViewById(R.id.img_black);


        point1= (ImageView) findViewById(R.id.point1);
        point2= (ImageView) findViewById(R.id.point2);
        point3= (ImageView) findViewById(R.id.point3);

        //设置默认图片
        setPointImg(true,false,false);

        mViewPager= (ViewPager) findViewById(R.id.mViewPager);
        view1=View.inflate(this,R.layout.page_item_one,null);
        view2=View.inflate(this,R.layout.page_item_two,null);
        view3=View.inflate(this,R.layout.page_item_three,null);


        mList.add(view1);
        mList.add(view2);
        mList.add(view3);
        //设置适配器
        mViewPager.setAdapter(new GuideAdapter());

        //监听ViewPage滑动
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            //page切换
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        setPointImg(true,false,false);
                        img_black.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        setPointImg(false,true,false);
                        img_black.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        setPointImg(false,false,true);
                        img_black.setVisibility(View.GONE);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //进入按钮
        btn_start= (Button) view3.findViewById(R.id.btn_start);
        btn_start.setOnClickListener(this);
        //跳过按钮
        img_black.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start:
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
            case R.id.img_black:
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
        }
    }

    class GuideAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ((ViewPager)container).addView(mList.get(position));
            return mList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager)container).removeView(mList.get(position));

        }
    }
    private void setPointImg(boolean isCheck1,boolean isCheck2,boolean isCheck3){
        if(isCheck1){
            point1.setImageResource(R.drawable.point_on);
        }else{
            point1.setImageResource(R.drawable.point_off);
        }
        if(isCheck2){
            point2.setImageResource(R.drawable.point_on);
        }else{
            point2.setImageResource(R.drawable.point_off);
        }if(isCheck3){
            point3.setImageResource(R.drawable.point_on);
        }else{
            point3.setImageResource(R.drawable.point_off);
        }
    }
}

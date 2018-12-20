package com.zxjaihhl.yds.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.zxjaihhl.yds.R;
import com.zxjaihhl.yds.utils.SharedUtils;
import com.zxjaihhl.yds.utils.StaticClass;
import com.zxjaihhl.yds.utils.UtilTools;

/**
 * Created by Administrator on 2017/9/13.
 * 描述：
 */

public class SplashActivity extends AppCompatActivity {
    /**
     * 1.延时2000ms
     * 2.判断程序是否第一次运行
     * 3.自定义字体
     * 4.Activity全屏主题
     */

    private TextView tv_splash;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case StaticClass.HANDLER_SPLASH:
                    //判断程序是否是第一次运行
                    if (isFirst()){
                        startActivity(new Intent(SplashActivity.this,GuideActivity.class));
                    }else{
                        startActivity(new Intent(SplashActivity.this,GuideActivity.class));
                    }
                    finish();
                    break;
            }
        }
    };


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
    }
    //初始化View
    private void initView() {
        //延迟2000ms
        handler.sendEmptyMessageDelayed(StaticClass.HANDLER_SPLASH,2000);
        tv_splash= (TextView) findViewById(R.id.tv_splash);
        //设置字体
        UtilTools.setlFont(this,tv_splash);

    }
    //判断程序是否第一次运行方法
    private boolean isFirst() {

        boolean isFirst= SharedUtils.getBoolean(this,StaticClass.SHARE_IS_FIRST,true);
        if(isFirst){
            SharedUtils.putBoolean(this,StaticClass.SHARE_IS_FIRST,false);
            //是第一运行
            return  true;
        }else {
            return false;
        }
    }
}

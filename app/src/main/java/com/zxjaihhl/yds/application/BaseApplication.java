package com.zxjaihhl.yds.application;

import android.app.Application;

import com.inuker.bluetooth.library.BluetoothContext;

/**
 * Created by Administrator on 2017/9/13.
 * 描述：
 */

public class BaseApplication extends Application {
    private static BaseApplication instance;

    public static Application getInstance() {
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        BluetoothContext.set(this);
//        //初始化Bugly
//        CrashReport.initCrashReport(getApplicationContext(), StaticClass.BUGLY_APP_ID, true);
//        //初始化Dmob
//        Bmob.initialize(this, StaticClass.BMOB_APP_ID);
//        // 将“12345678”替换成您申请的APPID，申请地址：http://open.voicecloud.cn
//        SpeechUtility.createUtility(getApplicationContext(), SpeechConstant.APPID + "=" + StaticClass.VOICE_KEY);
//        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
//        //注意该方法要再setContentView方法之前实现
//        SDKInitializer.initialize(getApplicationContext());
    }
}

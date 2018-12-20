package com.zxjaihhl.yds.manager;

import com.inuker.bluetooth.library.BluetoothClient;
import com.zxjaihhl.yds.application.BaseApplication;

/**
 * Created by Administrator on 2017/9/20.
 * 描述：
 */

public class ClientManager {
    private static BluetoothClient mClient;

    public static BluetoothClient getClient() {
        if (mClient == null) {
            synchronized (ClientManager.class) {
                if (mClient == null) {
                    mClient = new BluetoothClient(BaseApplication.getInstance());
                }
            }
        }
        return mClient;
    }


}

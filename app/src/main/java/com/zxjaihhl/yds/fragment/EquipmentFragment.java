package com.zxjaihhl.yds.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.inuker.bluetooth.library.connect.listener.BleConnectStatusListener;
import com.inuker.bluetooth.library.connect.listener.BluetoothStateListener;
import com.inuker.bluetooth.library.connect.options.BleConnectOptions;
import com.inuker.bluetooth.library.connect.response.BleConnectResponse;
import com.inuker.bluetooth.library.model.BleGattCharacter;
import com.inuker.bluetooth.library.model.BleGattProfile;
import com.inuker.bluetooth.library.model.BleGattService;
import com.inuker.bluetooth.library.search.SearchRequest;
import com.inuker.bluetooth.library.search.SearchResult;
import com.inuker.bluetooth.library.search.response.SearchResponse;
import com.zxjaihhl.yds.R;
import com.zxjaihhl.yds.manager.ClientManager;
import com.zxjaihhl.yds.model.DetailItem;
import com.zxjaihhl.yds.ui.CharacterActivity;
import com.zxjaihhl.yds.utils.SharedUtils;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import butterknife.ButterKnife;

import static com.inuker.bluetooth.library.Constants.REQUEST_SUCCESS;
import static com.inuker.bluetooth.library.Constants.STATUS_CONNECTED;
import static com.inuker.bluetooth.library.Constants.STATUS_DISCONNECTED;

/**
 * Created by zxjaihhl on 2017/11/17.
 */

public class EquipmentFragment extends Fragment {
    private ProgressBar pb_temperature,pb_battery;
    private TextView tv_temperature;
    private ImageView iv_car;
    private int battery;
    private TextView tv_ble_title;
    private Button bt_ble_search, bt_ble_connect;
    private String MAC;
    private String UUID_KEY_ONE = "00002A27-0000-1000-8000-00805F9B34FB";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_equipment, null);
        ButterKnife.bind(getActivity());
        ClientManager.getClient().openBluetooth();
        findView(view);
        initData();
        //连接监听
        ClientManager.getClient().registerConnectStatusListener(MAC, mBleConnectStatusListener);
        //打开蓝牙监听
        ClientManager.getClient().registerBluetoothStateListener(mBluetoothStateListener);
        return view;
    }
    private final BluetoothStateListener mBluetoothStateListener = new BluetoothStateListener() {
        @Override
        public void onBluetoothStateChanged(boolean openOrClosed) {
            if(openOrClosed){
                Toast.makeText(getActivity(), "蓝牙已打开", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getActivity(), "请打开蓝牙", Toast.LENGTH_SHORT).show();
            }

        }

    };
    private final BleConnectStatusListener mBleConnectStatusListener = new BleConnectStatusListener() {

        @Override
        public void onConnectStatusChanged(String mac, int status) {
            if (status == STATUS_CONNECTED) {

            } else if (status == STATUS_DISCONNECTED) {
                Toast.makeText(getActivity(), "请重新连接设备", Toast.LENGTH_SHORT).show();
            }
        }
    };

    private void initData() {
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        iv_car.getLayoutParams().height = width;
        iv_car.getLayoutParams().width = width;
        pb_temperature.getLayoutParams().width = width/3;
        pb_battery.getLayoutParams().width=width/5;
    }

    private void findView(View view) {
        pb_battery= (ProgressBar) view.findViewById(R.id.pb_battery);
        iv_car= (ImageView) view.findViewById(R.id.iv_car);
        pb_temperature= (ProgressBar) view.findViewById(R.id.pb_temperature);
        tv_temperature= (TextView) view.findViewById(R.id.tv_temperature);
        pb_temperature.setMax(40);
        pb_temperature.setProgress(27);
        pb_battery.setMax(100);
        pb_battery.setProgress(50);
        bt_ble_connect = (Button) view.findViewById(R.id.bt_ble_connect);
        bt_ble_connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                connectBle();
            }
        });
        bt_ble_search = (Button) view.findViewById(R.id.bt_ble_search);
        bt_ble_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchDevice();
            }
        });
        tv_ble_title = (TextView) view.findViewById(R.id.tv_ble_title);
        tv_ble_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    //扫描BLE设备
    private void searchDevice() {

        SearchRequest request = new SearchRequest.Builder()
                .searchBluetoothLeDevice(5000, 2).build();

        ClientManager.getClient().search(request, mSearchResponse);
    }

    private final SearchResponse mSearchResponse = new SearchResponse() {
        @Override
        public void onSearchStarted() {
            Toast.makeText(getActivity(), "设备搜索中", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onDeviceFounded(SearchResult device) {
            MAC = device.getAddress();
            tv_ble_title.setText(device.getName());

        }

        @Override
        public void onSearchStopped() {

        }

        @Override
        public void onSearchCanceled() {

        }
    };
    private void getUuid(List<DetailItem> list) {
        for (int i = 0; i < list.size(); i++) {
            final DetailItem result = list.get(i);
            if (result.type == DetailItem.TYPE_SERVICE) {
//                Toast.makeText(this, String.format("Service: %s", result.uuid.toString().toUpperCase()), Toast.LENGTH_SHORT).show();

            } else if (result.type == DetailItem.TYPE_CHARACTER & result.uuid.toString().toUpperCase().equals(UUID_KEY_ONE)) {
//                Toast.makeText(this, String.format("Characteristic: %s", result.uuid.toString().toUpperCase()), Toast.LENGTH_SHORT).show();

                startCharacterActivity(result.service, result.uuid);
            }

        }


    }

    private void startCharacterActivity(UUID service, UUID character) {
        Intent intent = new Intent(getActivity(), CharacterActivity.class);
        intent.putExtra("mac", MAC);
        intent.putExtra("service", service);
        intent.putExtra("character", character);
        startActivity(intent);
    }

    //连接设备
    private void connectBle() {
        BleConnectOptions options = new BleConnectOptions.Builder()
                .setConnectRetry(3)
                .setConnectTimeout(20000)
                .setServiceDiscoverRetry(3)
                .setServiceDiscoverTimeout(10000)
                .build();
        ClientManager.getClient().connect(MAC, options, new BleConnectResponse() {
            @Override
            public void onResponse(int code, BleGattProfile profile) {
                if (code == REQUEST_SUCCESS) {
                    Toast.makeText(getActivity(), "成功连接到设备", Toast.LENGTH_SHORT).show();
                    setGattProfile(profile);
                }
            }
        });

    }


    public void setGattProfile(BleGattProfile profile) {
        Toast.makeText(getActivity(), "正在分解", Toast.LENGTH_SHORT).show();
        List<DetailItem> items = new ArrayList<DetailItem>();

        List<BleGattService> services = profile.getServices();

        for (BleGattService service : services) {
            items.add(new DetailItem(DetailItem.TYPE_SERVICE, service.getUUID(), null));
//            Toast.makeText(this, String.format("Service: %s", service.getUUID().toString().toUpperCase()), Toast.LENGTH_SHORT).show();
            List<BleGattCharacter> characters = service.getCharacters();
            for (BleGattCharacter character : characters) {
                items.add(new DetailItem(DetailItem.TYPE_CHARACTER, character.getUuid(), service.getUUID()));

            }
        }
        getUuid(items);
    }

}

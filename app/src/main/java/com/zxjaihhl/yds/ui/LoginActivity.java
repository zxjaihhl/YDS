package com.zxjaihhl.yds.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zxjaihhl.yds.MainActivity;
import com.zxjaihhl.yds.R;
import com.zxjaihhl.yds.utils.SharedUtils;
import com.zxjaihhl.yds.utils.StaticClass;
import com.zxjaihhl.yds.utils.UtilTools;
import com.zxjaihhl.yds.view.CustomDialog;

/**
 * Created by Administrator on 2017/9/13.
 * 描述：
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_register, btn_login;
    private EditText et_pass, et_user;
    private CheckBox keeppass;
    private TextView tv_forget;
    private Dialog dialog_login;
    private ImageView iv_myphoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        btn_register = (Button) findViewById(R.id.btn_register);
        btn_register.setOnClickListener(this);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
        et_pass = (EditText) findViewById(R.id.et_pass);
        et_user = (EditText) findViewById(R.id.et_user);
        keeppass = (CheckBox) findViewById(R.id.keeppass);
        tv_forget = (TextView) findViewById(R.id.tv_forget);
        tv_forget.setOnClickListener(this);
        //设置Dilog
        dialog_login = new CustomDialog(this, 100, 100, R.layout.dialog_loding, R.style.Theme_dialog, Gravity.CENTER, R.style.pop_anim_style);
        //屏幕外点击无效
        dialog_login.setCancelable(false);
        iv_myphoto = (ImageView) findViewById(R.id.iv_myphoto);
        //设置头像图片
        UtilTools.getImageToShare(this, iv_myphoto);

        //设置选中状态
        boolean isCheck = SharedUtils.getBoolean(this, StaticClass.PASSWORD, false);
        keeppass.setChecked(isCheck);
        if (isCheck) {
            //设置记住密码
            et_user.setText(SharedUtils.getString(this, StaticClass.NAME, ""));
            et_pass.setText(SharedUtils.getString(this, StaticClass.PASS, ""));
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register:

                break;
            case R.id.btn_login:
                dialog_login.show();
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.tv_forget:

                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //保存记住密码状态
        SharedUtils.putBoolean(this, StaticClass.PASSWORD, keeppass.isChecked());

        //是否记住密码
        if (keeppass.isChecked()) {
            //记住用户密码
            SharedUtils.putString(this, StaticClass.NAME, et_user.getText().toString().trim());
            SharedUtils.putString(this, StaticClass.PASS, et_pass.getText().toString().trim());
        } else {
            SharedUtils.deleShare(this, StaticClass.NAME);
            SharedUtils.deleShare(this, StaticClass.PASS);

        }

    }
}

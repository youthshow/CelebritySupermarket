package com.celebritysupermarket.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.celebritysupermarket.R;
import com.celebritysupermarket.base.BaseActivity;
import com.celebritysupermarket.utils.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class LoginActivity extends BaseActivity  {

    private EditText user;
    private EditText pwd;
    private CheckBox cb;
    private TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        initData();

    }


    private void initView() {

        user = (EditText) findViewById(R.id.login_user);
        pwd = (EditText) findViewById(R.id.login_pwd);
        cb = (CheckBox) findViewById(R.id.login_checkbox);
        login = (TextView) findViewById(R.id.login);


    }

    private void initData() {

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OutputStream os = null;
                String userName = user.getText().toString().trim();
                String userPwd = pwd.getText().toString().trim();

                if (TextUtils.isEmpty(userName)) {
                    user.setError("帐号不能为空");
                    return;
                }

                if (TextUtils.isEmpty(userPwd)) {
                    pwd.setError("密码不能为空");
                    return;
                }

                if (cb.isChecked()) {
                    try {
                        File file = new File(getFilesDir(), "login.txt");
                        os = new FileOutputStream(file);
                        String user = userName + "#" + userPwd;
                        os.write(user.getBytes());


                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        IOUtils.close(os);
                    }

                }

                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }




}

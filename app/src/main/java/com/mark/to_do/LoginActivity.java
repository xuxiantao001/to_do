package com.mark.to_do;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by xuxiantao on 2015/8/14.
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEdtUserName;
    private EditText mEdtPassword;
    private Button mBtnLogin;
    private TextView mTxtSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Bmob.initialize(this, "6ce838563a3e7555da282eb70461cefc");

        mEdtUserName = (EditText) findViewById(R.id.edt_username);
        mEdtPassword = (EditText) findViewById(R.id.edt_password);
        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mBtnLogin.setOnClickListener(this);

        mTxtSignUp = (TextView) findViewById(R.id.txt_regist);
        mTxtSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:

                if(mEdtUserName.getText().toString().equals("") || mEdtPassword.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    BmobUser user = new BmobUser();
                    user.setUsername(mEdtUserName.getText().toString());
                    user.setPassword(mEdtPassword.getText().toString());
                    user.login(this, new SaveListener() {
                        @Override
                        public void onSuccess() {
                            Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(int i, String s) {
                            Toast.makeText(getApplicationContext(), "用户名或密码错误", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

                break;

            case R.id.txt_regist:

                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);

                break;
        }
    }
}

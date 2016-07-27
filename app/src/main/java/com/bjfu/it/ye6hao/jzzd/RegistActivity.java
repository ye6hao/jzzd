package com.bjfu.it.ye6hao.jzzd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bjfu.it.ye6hao.jzzd.model.User;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class RegistActivity extends AppCompatActivity {

    private TextView mUsername;
    private TextView mPassword;

    private User newUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regist);
    }


    public void doRegist(View view) {

        mUsername = (EditText) findViewById(R.id.username);
        mPassword = (EditText) findViewById(R.id.password);

        String username = mUsername.getText().toString();
        String password = mPassword.getText().toString();

        newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setAge(0);
        newUser.setCareer("");
        //newUser.setHeadImage();
        newUser.setNick(username);
        newUser.setSex(true);
        newUser.setSignature("讲座之道搞得不错！");
        newUser.setUserType("普通");

        //注意：不能用save方法进行注册。注册成功后直接跳到index.xml

        /*
        * 注册成功后会将新注册的User信息保存道本地＊＊＊＊＊＊这个非常重要
        * */
        newUser.signUp(new SaveListener<User>() {
            @Override
            public void done(User s, BmobException e) {
                if (e == null) {
                    Toast.makeText(RegistActivity.this, "注册成功", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent();
                    intent.setClass(RegistActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();


                } else {
                    Toast.makeText(RegistActivity.this, "注册失败" + e, Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}

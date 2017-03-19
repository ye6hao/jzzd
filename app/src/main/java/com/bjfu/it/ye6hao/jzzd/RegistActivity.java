package com.bjfu.it.ye6hao.jzzd;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
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
        requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
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
        newUser.setNick(username);
        newUser.setGuideInfo(false);
        newUser.setAge(0);
        newUser.setSex(false);
        newUser.setSignature("好好学习，天天向上！");
        newUser.setUserType("普通");
        //注意：不能用save方法进行注册。注册成功后直接跳到index.xml


        /*
        * 注册成功后会将新注册的User信息保存道本地＊＊＊＊＊＊这个非常重要
        * */

        //注册未登录是不能获得本地用户的，除非登录过。你确认下是否之前登录过。
        newUser.signUp(new SaveListener<User>() {
            @Override
            public void done(User s, BmobException e) {
                if (e == null) {
                    Log.i("RegistActivity","success");
                    Intent intent = new Intent();
                    intent.setClass(RegistActivity.this , LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Log.i("RegistActivity","fail"+e.toString());
                }
            }
        });

    }
}

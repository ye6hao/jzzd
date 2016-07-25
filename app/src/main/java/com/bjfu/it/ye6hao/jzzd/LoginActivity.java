package com.bjfu.it.ye6hao.jzzd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bjfu.it.ye6hao.jzzd.model.User;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class LoginActivity extends AppCompatActivity {


    private TextView mUsername;
    private TextView mPassword;

    private User loginUser;//用于登录验证

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        setContentView(R.layout.login);

        BmobConfig config =new BmobConfig.Builder(this)
        //设置appkey
        .setApplicationId("a9953c4f5ba5743562862f9163589cdb")
        //请求超时时间（单位为秒）：默认15s
        .setConnectTimeout(30)
        //文件分片上传时每片的大小（单位字节），默认512*1024
        .setUploadBlockSize(1024*1024)
        //文件的过期时间(单位为秒)：默认1800s
        .setFileExpiration(2500)
        .build();
        Bmob.initialize(config);
    }


    /*提交反馈信息*/
    public void doLogin(View view){
        mUsername=(EditText)findViewById(R.id.username);
        mPassword=(EditText)findViewById(R.id.password);


        String  username=mUsername.getText().toString();//用户名是唯一的可以用在。通过用户名可以和用户信息连接
        String password=mPassword.getText().toString();



        //登陆成功怎么把用户传入到主页中。session？？？

        loginUser=new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);

         /*登陆验证*/

        loginUser.login(new SaveListener<User>() {

            @Override
            public void done(User user, BmobException e) {
                if(e==null){
                    Toast.makeText(LoginActivity.this,"submit success",Toast.LENGTH_LONG).show();
                    //登陆成功跳转到index主页面
                    //传递用户名和用户id
                    Intent intent=new Intent();
                    //将登陆成功的用户名存放到
                    intent.putExtra("username",loginUser.getUsername());
                    intent.setClass(LoginActivity.this,IndexActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this,"登录失败:"+e,Toast.LENGTH_LONG).show();
                }
            }

        });

    }

    /*跳转到注册页面*/
    public void goToRegist(View  view){
        Intent intent=new Intent();
        intent.setClass(LoginActivity.this,RegistActivity.class);
        startActivity(intent);
    }
}

package com.bjfu.it.ye6hao.jzzd;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bjfu.it.ye6hao.jzzd.model.User;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

public class AlterInfoActivity extends AppCompatActivity {

    private Context context;
    private TextView personal_title;    //个人中心标题
    private User loginUser;//声明存放在本地的用户

    /*****************************************************/

    private EditText personal_age;              //1、年龄
    private EditText personal_career;           //2、职业
    //private ImageView personal_headImage = null; //头像，另外修改
    private EditText personal_nick;             //3、昵称
    private EditText personal_sex;              //4、性别
    private EditText personal_signature;        //5、个性签名

    /*****************************************************/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alter_personal_info);

        personal_age = (EditText) findViewById(R.id.personal_age);
        personal_career = (EditText) findViewById(R.id.personal_career);
        personal_nick = (EditText) findViewById(R.id.personal_nick);
        personal_sex = (EditText) findViewById(R.id.personal_sex);
        personal_signature = (EditText) findViewById(R.id.personal_signature);

        //获取本地用户信息
        loginUser= User.getCurrentUser(User.class);
        fillInfo(loginUser);
    }


    //修改个人信息，本地和服务器数据同时修改
    public void doAlterPersonalInfo(View v){

        loginUser= User.getCurrentUser(User.class);//得到本地User

        //新的值赋给本地User
        loginUser.setAge(Integer.valueOf(personal_age.getText().toString()));

        loginUser.setCareer(personal_career.getText().toString());
        loginUser.setNick(personal_nick.getText().toString());

        boolean temp_sex = true;
        if (personal_sex.getText().toString().equals("男")) {
            temp_sex = true;
        } else {
            temp_sex = false;
        }

        loginUser.setSex(temp_sex);
        loginUser.setSignature(personal_signature.getText().toString());


        //修改本地和服务器上的User
        loginUser.update(new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if(e==null){
                    Toast.makeText(AlterInfoActivity.this,"修改成功",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent();
                    setResult(RESULT_OK,intent);
                    //修改成功自动销毁修改Activity
                    finish();

                }else{
                    Toast.makeText(AlterInfoActivity.this,"修改失败:" + e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });

    }


    /*如果没有修改，点击返回键，返回*/
    @Override
    public void onBackPressed() {
        Toast.makeText(AlterInfoActivity.this,"没有修改信息，直接返回",Toast.LENGTH_LONG).show();
        Intent intent=new Intent();
        setResult(RESULT_OK,intent);
        //修改成功自动销毁修改Activity
        finish();

    }


    /*
     *根据本地存储的User填充到表格中:多处使用到，提取出来！！！
     */
    public void fillInfo(User loginUser) {

        /*设置用户的文字信息*/

        //设置age
        try {
            personal_age.setText(loginUser.getAge().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //设置职业
        try {
            personal_career.setText(loginUser.getCareer());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //设置nick
        if (loginUser.getNick() != null) {
            personal_nick.setText(loginUser.getNick());
        }
        //设置性别
        try {

            if (loginUser.getSex() == true) {
                personal_sex.setText("男");
            } else if (loginUser.getSex() == false) {
                personal_sex.setText("女");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //设置个性签名
        try {
            personal_signature.setText(loginUser.getSignature());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

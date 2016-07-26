package com.bjfu.it.ye6hao.jzzd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bjfu.it.ye6hao.jzzd.adapter.LectureAdapter;
import com.bjfu.it.ye6hao.jzzd.model.Lecture;
import com.bjfu.it.ye6hao.jzzd.model.User;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.FindListener;

public class IndexActivity extends AppCompatActivity {

    private  TextView username;
    ListView lecture_list_view;
    List<Lecture> lectureList = new ArrayList<>();


    private User localUser;//获取本地用户

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.index);


        username=(TextView) findViewById(R.id.username);

        lecture_list_view=(ListView)findViewById(R.id.lecture_list_view);

        //获取用户本地存储的信息
        localUser = User.getCurrentUser(User.class);

        //用户登录成功
        username.setText(localUser.getUsername()+"登录成功");

        //点击用户，进入个人中心


        username.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent=new Intent(IndexActivity.this,PersonalActivity.class);

                startActivity(intent);
            }

        });



    }




}

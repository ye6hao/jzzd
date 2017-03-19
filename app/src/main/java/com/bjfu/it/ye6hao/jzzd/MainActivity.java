package com.bjfu.it.ye6hao.jzzd;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.baidu.mapapi.SDKInitializer;
import com.bjfu.it.ye6hao.jzzd.dao.CustomApplication;
import com.bjfu.it.ye6hao.jzzd.map.MapFragment;
import com.bjfu.it.ye6hao.jzzd.message.MessageFragment;
import com.bjfu.it.ye6hao.jzzd.model.User;
import com.bjfu.it.ye6hao.jzzd.personal.PersonalFragment;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;

public class MainActivity extends FragmentActivity implements View.OnClickListener {


    private LinearLayout mTabIndex;
    private LinearLayout mTabMap;
    private LinearLayout mTabMessage;
    private LinearLayout mTabPersonal;

    private ImageButton mImgIndex;
    private ImageButton mImgMap;
    private ImageButton mImgMessage;
    private ImageButton mImgPersonal;

    private Fragment mTab01;    //index首页
    private Fragment mTab02;    //map地图
    private Fragment mTab03;    //message消息
    private Fragment mTab04;    //personal个人中心


    private User loginUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);

/*        CustomApplication cApp = (CustomApplication)getApplication();
        if (cApp.isExit()) {
            finish();
        }*/

        loginUser = BmobUser.getCurrentUser(User.class);

        if (loginUser.getGuideInfo() == false) {
            // 允许用户使用应用,进入主页面
            Intent intent = new Intent();
            //将登陆成功的用户名存放到(已经保存到了本地)
            intent.setClass(MainActivity.this, GuideActivity.class);
            startActivity(intent);

        }

        //初始化地图sdk
        SDKInitializer.initialize(getApplicationContext());
        initView();
        initEvent();
        setSelect(0);
    }



    private void initView()
    {
        mTabIndex = (LinearLayout) findViewById(R.id.id_tab_01_index);
        mTabMap = (LinearLayout) findViewById(R.id.id_tab_02_map);
        mTabMessage = (LinearLayout) findViewById(R.id.id_tab_03_message);
        mTabPersonal = (LinearLayout) findViewById(R.id.id_tab_04_personal);

        mImgIndex = (ImageButton) findViewById(R.id.id_tab_01_index_img);
        mImgMap = (ImageButton) findViewById(R.id.id_tab_02_map_img);
        mImgMessage = (ImageButton) findViewById(R.id.id_tab_03_message_img);
        mImgPersonal = (ImageButton) findViewById(R.id.id_tab_04_personal_img);
    }

    private void initEvent()
    {
        mTabIndex.setOnClickListener(this);
        mTabMap.setOnClickListener(this);
        mTabMessage.setOnClickListener(this);
        mTabPersonal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        resetImgs();
        switch (v.getId())
        {
            case R.id.id_tab_01_index:
                setSelect(0);
                break;
            case R.id.id_tab_02_map:
                setSelect(1);
                break;
            case R.id.id_tab_03_message:
                setSelect(2);
                break;
            case R.id.id_tab_04_personal:
                setSelect(3);
                break;

            default:
                break;
        }
    }

    private void setSelect(int i)
    {

       /*
        * android.app.Fragment
        * 使用(ListFragment)getFragmentManager().findFragmentById(R.id.userList) 
        * 获得,继承Activity
        *
        * android.support.v4.app.Fragment
        * 使用(ListFragment)getSupportFragmentManager().findFragmentById(R.id.userList)
        * 获得需要继承android.support.v4.app.FragmentActivity
        */


        /*
        *
        * 3.0以下：getSupportFragmentManager()
        * 3.0以上：getFragmentManager()
        * */

        //FragmentManager管理所有的Fragment
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();


        //隐藏所有的transaction中的tab
        hideFragment(transaction);

        // 把图片设置为亮的
        // 设置内容区域
        switch (i)
        {
            case 0:
                if (mTab01 == null) {


                    mTab01 = new IndexFragment();


                    //添加微信到Activity中
                    transaction.add(R.id.id_content, mTab01);


                } else {
                    //不为空显示出来
                    transaction.show(mTab01);
                }
                mImgIndex.setImageResource(R.drawable.tab_01_index_pressed);
                break;

            case 1:
                if (mTab02 == null) {
                    mTab02 = new MapFragment();//装载地图


                    transaction.add(R.id.id_content, mTab02);


                } else {
                    transaction.show(mTab02);

                }
                mImgMap.setImageResource(R.drawable.tab_02_map_pressed);
                break;

            case 2:
                if (mTab03 == null) {
                    mTab03 = new MessageFragment();
                    transaction.add(R.id.id_content, mTab03);
                } else {
                    transaction.show(mTab03);
                }
                mImgMessage.setImageResource(R.drawable.tab_03_message_pressed);
                break;

            case 3:
                if (mTab04 == null) {
                    mTab04 = new PersonalFragment();
                    transaction.add(R.id.id_content, mTab04);
                } else {
                    transaction.show(mTab04);
                }
                mImgPersonal.setImageResource(R.drawable.tab_04_personal_pressed);
                break;

            default:
                break;
        }

        transaction.commit();
    }


    /**
     * 隐藏Fragment
     */
    private void hideFragment(FragmentTransaction transaction)
    {
        if (mTab01 != null) {transaction.hide(mTab01);}
        if (mTab02 != null) {transaction.hide(mTab02);}
        if (mTab03 != null) {transaction.hide(mTab03);}
        if (mTab04 != null) {transaction.hide(mTab04);}
    }


    /**
     * 切换图片至暗色
     */
    private void resetImgs()
    {
        mImgIndex.setImageResource(R.drawable.tab_01_index_normal);
        mImgMap.setImageResource(R.drawable.tab_02_map_normal);
        mImgMessage.setImageResource(R.drawable.tab_03_message_normal);
        mImgPersonal.setImageResource(R.drawable.tab_04_personal_normal);
    }



    /**
     * 再按一次back键退出程序
     */
    private long exitTime = 0;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if((System.currentTimeMillis()-exitTime) > 2000){
                Toast.makeText(getApplicationContext(), "再按一次退出", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    protected void onStart() {
        super.onStart();
        CustomApplication cApp = (CustomApplication)getApplication();
        if (cApp.isExit()) {
            finish();
        }

    }
}

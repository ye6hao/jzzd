package com.bjfu.it.ye6hao.jzzd;
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

import com.bjfu.it.ye6hao.jzzd.map.MapFragment;
import com.bjfu.it.ye6hao.jzzd.message.MessageFragment;
import com.bjfu.it.ye6hao.jzzd.model.User;
import com.bjfu.it.ye6hao.jzzd.personal.PersonalFragment;

public class MainActivity extends FragmentActivity implements View.OnClickListener {


    private LinearLayout mTabWeixin;
    private LinearLayout mTabFrd;
    private LinearLayout mTabAddress;
    private LinearLayout mTabSettings;

    private ImageButton mImgWeixin;
    private ImageButton mImgFrd;
    private ImageButton mImgAddress;
    private ImageButton mImgSettings;

    private Fragment mTab01;    //分类显示
    private Fragment mTab02;    //地图
    private Fragment mTab03;    //消息
    private Fragment mTab04;    //个人中心

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        initView();
        initEvent();
        setSelect(0);
    }

    private void initEvent()
    {
        mTabWeixin.setOnClickListener(this);
        mTabFrd.setOnClickListener(this);
        mTabAddress.setOnClickListener(this);
        mTabSettings.setOnClickListener(this);
    }

    private void initView()
    {
        mTabWeixin = (LinearLayout) findViewById(R.id.id_tab_01_index);
        mTabFrd = (LinearLayout) findViewById(R.id.id_tab_02_map);
        mTabAddress = (LinearLayout) findViewById(R.id.id_tab_03_message);
        mTabSettings = (LinearLayout) findViewById(R.id.id_tab_04_personal);

        mImgWeixin = (ImageButton) findViewById(R.id.id_tab_01_index_img);
        mImgFrd = (ImageButton) findViewById(R.id.id_tab_02_map_img);
        mImgAddress = (ImageButton) findViewById(R.id.id_tab_03_message_img);
        mImgSettings = (ImageButton) findViewById(R.id.id_tab_04_personal_img);
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
                mImgWeixin.setImageResource(R.drawable.tab_01_index_pressed);
                break;

            case 1:
                if (mTab02 == null) {
                    mTab02 = new MapFragment();
                    transaction.add(R.id.id_content, mTab02);
                } else {
                    transaction.show(mTab02);

                }
                mImgFrd.setImageResource(R.drawable.tab_02_map_pressed);
                break;

            case 2:
                if (mTab03 == null) {
                    mTab03 = new MessageFragment();
                    transaction.add(R.id.id_content, mTab03);
                } else {
                    transaction.show(mTab03);
                }
                mImgAddress.setImageResource(R.drawable.tab_03_message_pressed);
                break;

            case 3:
                if (mTab04 == null) {
                    mTab04 = new PersonalFragment();
                    transaction.add(R.id.id_content, mTab04);
                } else {
                    transaction.show(mTab04);
                }
                mImgSettings.setImageResource(R.drawable.tab_04_personal_pressed);
                break;

            default:
                break;
        }

        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction)
    {
        if (mTab01 != null)
        {
            transaction.hide(mTab01);
        }
        if (mTab02 != null)
        {
            transaction.hide(mTab02);
        }
        if (mTab03 != null)
        {
            transaction.hide(mTab03);
        }
        if (mTab04 != null)
        {
            transaction.hide(mTab04);
        }
    }


    /**
     * 切换图片至暗色
     */
    private void resetImgs()
    {
        mImgWeixin.setImageResource(R.drawable.tab_01_index_normal);
        mImgFrd.setImageResource(R.drawable.tab_02_map_normal);
        mImgAddress.setImageResource(R.drawable.tab_03_message_normal);
        mImgSettings.setImageResource(R.drawable.tab_04_personal_normal);
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


    //创建菜单项，退出登录
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    //这个菜单在右上角，观察不到。。。。。。
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.user_log_out:
                User.logOut();   //清除缓存用户对象
                User currentUser = User.getCurrentUser(User.class); // 现在的currentUser是null了
                finish();
                System.exit(0);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }



    //回调接口，实现SettingFragment.MyListener中的itemClicked()方法

}

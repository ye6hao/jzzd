package com.bjfu.it.ye6hao.jzzd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bjfu.it.ye6hao.jzzd.adapter.LectureAdapter;
import com.bjfu.it.ye6hao.jzzd.model.Lecture;
import com.bjfu.it.ye6hao.jzzd.model.User;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobDate;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

public class IndexActivity extends AppCompatActivity {

    private  TextView mUsername;

    ListView mLectureListView;


    private User localUser;//获取本地用户

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //隐藏标题栏
        setContentView(R.layout.index);

        mUsername = (TextView) findViewById(R.id.username);
        mLectureListView = (ListView) findViewById(R.id.lecture_list_view);

        //获取用户本地存储的信息
        localUser = User.getCurrentUser(User.class);

        //用户登录成功
        mUsername.setText(localUser.getUsername()+"个人信息");
        //点击用户，进入个人中心
        mUsername.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent=new Intent(IndexActivity.this,PersonalActivity.class);
                startActivity(intent);
            }

        });



        /*查询数据库中的所有讲座信息*/
        BmobQuery<Lecture> query = new BmobQuery<Lecture>();
        //查询playerName叫“比目”的数据
        query.addWhereEqualTo("speaker", "童道明");
        //返回50条数据，如果不加上这条语句，默认返回10条数据
        query.setLimit(50);
        //执行查询方法
        query.findObjects(new FindListener<Lecture>() {
            @Override
            public void done(List<Lecture> lectureList, BmobException e) {
                if (e == null) {

                    //Toast.makeText(IndexActivity.this, "查询成功：共" + lectureList.size() + "条数据。", Toast.LENGTH_SHORT).show();
                    // 向适配器中注入数据
                    mLectureListView.setAdapter(new LectureAdapter(IndexActivity.this, lectureList));
                } else {
                    Log.i("bmob", "失败：" + e.getMessage() + "," + e.getErrorCode());
                }
            }
        });

        //添加ItemClick点击事件。listViewListener为监听器没成
        mLectureListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View view, int position, long id) {
                //得到当前item上的Lecture。。。
                Lecture lecture=(Lecture) listView.getItemAtPosition(position);
                Bundle bundle=new Bundle();
                bundle.putSerializable("lectureInfo",lecture);
                //把这个Item中的信息传递到LectureInfo中
                Intent intent=new Intent();
                intent.putExtras(bundle);
                intent.setClass(IndexActivity.this,LectureInfoActivity.class);
                startActivity(intent);
            }
        });

    }


    private void  createLecture(){

        Lecture lecture = new Lecture();
        //注意：lecture.setObjectId("")方法
        for(int i=1;i<=10;i++){
            lecture.setTopic("戏剧的美妙－从契诃夫谈起"+String.valueOf(i));
            lecture.setTopicIntro("这个是主题简介，此处省略好多字……");
            lecture.setSpeaker("童道明");
            lecture.setSpeakerIntro("中国著名翻译家、戏剧评论家");
            BmobDate date=BmobDate.createBmobDate("yyyy-MM-dd HH:mm","2016-08-25 19:00");
            lecture.setLectureDate(date);
            lecture.setLocation("北京林业大学二教110");
            lecture.setTypeId("人文社科类");
            lecture.setHost("无");
            lecture.setStatus(true);
            lecture.setHotNum(0);
            lecture.setFavoriteNum(0);
            lecture.setSourceFrom("测试");

            lecture.save(new SaveListener<String>() {

                @Override
                public void done(String objectId, BmobException e) {
                    if (e == null) {
                        //Toast.makeText(IndexActivity.this,"创建数据成功:" + e.getMessage(),Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(IndexActivity.this,"失败:" + e.getErrorCode(),Toast.LENGTH_LONG).show();

                    }
                }
            });
        }


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
        getMenuInflater().inflate(R.menu.index, menu);
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
}

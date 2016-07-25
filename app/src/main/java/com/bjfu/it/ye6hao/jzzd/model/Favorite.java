package com.bjfu.it.ye6hao.jzzd.model;

import java.io.Serializable;

import cn.bmob.v3.BmobObject;

/**
 * Created by yellow_hao on 2016/6/24.
 */
public class Favorite extends BmobObject implements Serializable {

    private String lecture_id; //讲座编号
    private String user_id;    //用户编号

    public Favorite() {
        super();
    }
    public String getLecture_id() {
        return lecture_id;
    }

    public void setLecture_id(String lecture_id) {
        this.lecture_id = lecture_id;
    }


    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }



}

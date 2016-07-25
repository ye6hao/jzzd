package com.bjfu.it.ye6hao.jzzd.model;

import java.io.Serializable;

import cn.bmob.v3.BmobObject;

/**
 * Created by yellow_hao on 2016/6/16.
 */

/*
* java.sql.Date是java.util.Date的子类，是一个包装了毫秒值的瘦包装器，
* 允许 JDBC 将毫秒值标识为 SQL DATE 值。
* 毫秒值表示自 1970 年 1 月 1 日 00:00:00 GMT 以来经过的毫秒数。
* 为了与 SQL DATE 的定义一致，由 java.sql.Date 实例包装的毫秒值必须通过
* 将时间、分钟、秒和毫秒设置为与该实例相关的特定时区中的零来“规范化”。
* 说白了，java.sql.Date就是与数据库Date相对应的一个类型，
* 而java.util.Date是纯java的Date。
*/


//讲座信息表lecture，11个参数
public class Lecture extends BmobObject implements Serializable {

    @Override
    public String toString() {
        return
                "主题简介:"+'\t' + topic_intro +'\n' +
                "主讲简介: "+'\t' + speaker_intro +'\n' +
                "开始日期: " +'\t'+ start_date +'\n' +
                "时间:" + '\t'+ start_time +'\n' +
                "位置"+ '\t' + location +'\n' +
                "类型" + '\t'+ type_name+'\n' +
                "状态:" + '\t'+ status+'\n' +
                "关注度:"+ '\t' + hot;
    }

    public Lecture() {
        super();
    }

    //private  Integer    lecture_id;         //1讲座编号
    private String topic;               //2讲座主题
    private String speaker;            //3讲座嘉宾
    private String topic_intro;        //4主题简介
    private String speaker_intro;      //5嘉宾简介


    /*    private Date    start_date;         //6开始日期 年月日
        private Time    start_time;           //7开始时间  时分秒*/
    private String start_date;         //6开始日期 年月日
    private String start_time;           //7开始时间  时分秒


    private String location;           //8位置
    private String type_name;         //9讲座类型
    private Boolean status;             //10建立一个线程，true为on ；false为off
    private Integer hot;                    //11关注数量





    public String getStart_time() {
        return start_time;
    }
    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }
    public String getStart_date() {
        return start_date;
    }
    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }



/*    public int getLecture_id() {
        return lecture_id;
    }

    public void setLecture_id(int lecture_id) {
        this.lecture_id = lecture_id;
    }*/

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getTopic_intro() {
        return topic_intro;
    }

    public void setTopic_intro(String topic_intro) {
        this.topic_intro = topic_intro;
    }

    public String getSpeaker_intro() {
        return speaker_intro;
    }

    public void setSpeaker_intro(String speaker_intro) {
        this.speaker_intro = speaker_intro;
    }

/*    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Time getStart_time() {
        return start_time;
    }

    public void setStart_time(Time start_time) {
        this.start_time = start_time;
    }*/

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }



}

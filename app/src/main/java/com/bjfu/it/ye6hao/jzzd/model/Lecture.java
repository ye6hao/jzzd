package com.bjfu.it.ye6hao.jzzd.model;

import java.io.Serializable;
import java.util.Date;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobDate;

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



    public Lecture() {
        super();
    }



    private String topic;           //1、讲座主题
    private String topicIntro;      //2、主题简介
    private String speaker;         //3、主讲人
    private String speakerIntro;    //4、主讲人简介
    private String host;            //5、主持人
    private String typeId;          //6、讲座类型编号

    private BmobDate lectureDate;    //7、讲座日期
    private String location;        //8、地址

    private boolean status;         //9、讲座状态：是否过时，false为过时
    private Integer hotNum;         //10、热度：浏览次数
    private Integer favorateNum;    //11、收藏量
    private String sourceFrom;      //12、信息来源


    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTopicIntro() {
        return topicIntro;
    }

    public void setTopicIntro(String topicIntro) {
        this.topicIntro = topicIntro;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getSpeakerIntro() {
        return speakerIntro;
    }

    public void setSpeakerIntro(String speakerIntro) {
        this.speakerIntro = speakerIntro;
    }

    public BmobDate getLectureDate() {
        return lectureDate;
    }

    public void setLectureDate(BmobDate lectureDate) {
        this.lectureDate = lectureDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Integer getHotNum() {
        return hotNum;
    }

    public void setHotNum(Integer hotNum) {
        this.hotNum = hotNum;
    }

    public Integer getFavorateNum() {
        return favorateNum;
    }

    public void setFavorateNum(Integer favorateNum) {
        this.favorateNum = favorateNum;
    }

    public String getSourceFrom() {
        return sourceFrom;
    }

    public void setSourceFrom(String sourceFrom) {
        this.sourceFrom = sourceFrom;
    }
}

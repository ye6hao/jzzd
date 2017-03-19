package com.bjfu.it.ye6hao.jzzd.model;

import com.bjfu.it.ye6hao.jzzd.map.MapInfo;

import java.io.Serializable;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobDate;
import cn.bmob.v3.datatype.BmobRelation;

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


    //讲座四要素
    private String topic;           //1、主题
    private String speaker;         //2、主讲
    private BmobDate lectureDate;   //3、日期
    private String location;        //4、详细地址


    private String topicIntro;      //8、主题简介
    private String speakerIntro;    //9、主讲人简介
    private String host;            //10、主持人或主办单位

    private boolean status;         //5、讲座状态：是否过时，false为过时

    private Integer hotNum;         //6、热度：浏览次数

    private String sourceFrom;      //7、信息来源





    //关联：3个Point 1个Relation

    private Type type;          //11、讲座类型编号
    private School school;          //12、学校或单位
    private MapInfo map;       //13、一个点可以有多条讲座，
    private BmobRelation likes;     //14、多对多关系：用于存储喜欢该帖子的所有用户



    //private User commitUser ; //讲座由谁发布的？

    /******************************************************************/

    @Override
    public String toString() {
        return  "讲座分享！\n"+
                "主题：" + topic + '\n' +
                "主讲：" + speaker + '\n' +
                "时间：" + lectureDate.getDate() + '\n' +
                "地址：" + location;
    }



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

    public String getSourceFrom() {
        return sourceFrom;
    }

    public void setSourceFrom(String sourceFrom) {
        this.sourceFrom = sourceFrom;
    }

    public String getTopicIntro() {
        return topicIntro;
    }

    public void setTopicIntro(String topicIntro) {
        this.topicIntro = topicIntro;
    }

    public String getSpeakerIntro() {
        return speakerIntro;
    }

    public void setSpeakerIntro(String speakerIntro) {
        this.speakerIntro = speakerIntro;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }


    public BmobRelation getLikes() {
        return likes;
    }

    public void setLikes(BmobRelation likes) {
        this.likes = likes;
    }

    public MapInfo getMap() {
        return map;
    }

    public void setMap(MapInfo map) {
        this.map = map;
    }


}

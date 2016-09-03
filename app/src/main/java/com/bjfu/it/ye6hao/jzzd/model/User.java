package com.bjfu.it.ye6hao.jzzd.model;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by yellow_hao on 2016/6/19.
 */



public class User extends BmobUser {


    /*
    BmobUser除了从BmobObject继承的属性外，还有几个特定的属性：
    username: 用户的用户名（必需）。
    password: 用户的密码（必需）。
    email: 用户的电子邮件地址（可选）。
    emailVerified:邮箱认证状态（可选）。
    mobilePhoneNumber：手机号码（可选）。
    mobilePhoneNumberVerified：手机号码的认证状态（可选）。
    */



    /*
    //BmobObject 封装完成，此处不用再去实现
    private String objectId;  //编号
    private String username;  //用户名
    private String password;  //密码
    */

   //按26个字母排序
    private Integer     age;            //年龄
    private String      career;         //职业
    private BmobFile    headImage;      //头像
    private String      nick;           //别名
    private Boolean     sex;            //性别
    private String      signature;      //个性签名
    private String      userType;       //用户类型


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public BmobFile getHeadImage() {
        return headImage;
    }

    public void setHeadImage(BmobFile headImage) {
        this.headImage = headImage;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }


    @Override
    public String toString() {
        return "User{" +
                "userType='" + userType + '\'' +
                ", signature='" + signature + '\'' +
                ", nick='" + nick + '\'' +
                ", career='" + career + '\'' +
                ", age=" + age +
                '}';
    }

}

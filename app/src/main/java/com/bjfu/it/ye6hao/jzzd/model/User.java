package com.bjfu.it.ye6hao.jzzd.model;

import cn.bmob.v3.BmobUser;

/**
 * Created by yellow_hao on 2016/6/19.
 */


/*BmobUser除了从BmobObject继承的属性外，还有几个特定的属性：
username: 用户的用户名（必需）。
password: 用户的密码（必需）。
email: 用户的电子邮件地址（可选）。
emailVerified:邮箱认证状态（可选）。
mobilePhoneNumber：手机号码（可选）。
mobilePhoneNumberVerified：手机号码的认证状态（可选）。*/
public class User extends BmobUser {

    private Boolean sex;
    private String nick;
    private Integer age;

    @Override
    public String toString() {
        return "User{" +
                "sex=" + sex +
                ", nick='" + nick + '\'' +
                ", age=" + age +
                '}';
    }

    public boolean getSex() {
        return this.sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getNick() {
        return this.nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


}

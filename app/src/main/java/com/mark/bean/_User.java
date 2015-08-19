package com.mark.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by xuxiantao on 2015/8/14.
 */
public class _User extends BmobObject {

    private String username;
    private String password;
    private String email;
    private String birthday;
    private String gender;

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {

        return birthday;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getUserName() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

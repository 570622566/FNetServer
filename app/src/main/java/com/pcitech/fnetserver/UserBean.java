package com.pcitech.fnetserver;

/**
 * @author laijian
 * @version 2017/12/4
 * @Copyright (C)下午6:11 , www.hotapk.cn
 */
public class UserBean {

    private String userName="";
    private String passw="";

    public UserBean() {
    }

    public UserBean(String userName, String passw) {
        this.userName = userName;
        this.passw = passw;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }
}

package com.sap.entity;

public class User {

    private Integer userId;
    private String userName;
    private String userPwd;
    private String userAvatar;
    private String userType;
    private Integer userLocked;
    private Integer userCredit;
    private String userLastVisit;
    private String userLastIp;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Integer getUserLocked() {
        return userLocked;
    }

    public void setUserLocked(Integer userLocked) {
        this.userLocked = userLocked;
    }

    public Integer getUserCredit() {
        return userCredit;
    }

    public void setUserCredit(Integer userCredit) {
        this.userCredit = userCredit;
    }

    public String getUserLastVisit() {
        return userLastVisit;
    }

    public void setUserLastVisit(String userLastVisit) {
        this.userLastVisit = userLastVisit;
    }

    public String getUserLastIp() {
        return userLastIp;
    }

    public void setUserLastIp(String userLastIp) {
        this.userLastIp = userLastIp;
    }

    @Override
    public String toString() {
        return " User [ userId" + userId +
                "userName" + userName +
                "userPwd" + userPwd +
                "userAvatar" + userAvatar +
                "userType" + userType +
                "userLocked" + userLocked +
                "userCredit" + userCredit +
                "userLastVisit" + userLastVisit +
                "userLastIp" + userLastIp +
                " ] ";
    }
}
package com.netease.mall.Vo;

public class UserVo extends Entity {
    private String userId;

    private String userName;

    private String password;

    private Integer userType;

    public UserVo() {
        super();
    }

    public UserVo(String userId, String username, String password, Integer userType) {
        this();
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.userType = userType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }
}

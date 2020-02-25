package com.dekopay.model;

import com.google.gson.annotations.SerializedName;

public class User implements Comparable<User> {

    @SerializedName(value = "user_id")
    private Long userId;

    @SerializedName(value = "first_name")
    private String firstName;

    @SerializedName(value = "last_name")
    private String lastName;

    @SerializedName(value = "username")
    private String userName;

    @SerializedName(value = "user_type")
    private type userType;

    @SerializedName(value = "last_login_time")
    private String lastLoginTime;

    public enum type {
        Employee,
        Manager,
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public type getUserType() {
        return userType;
    }

    public void setUserType(type userType) {
        this.userType = userType;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public int compareTo(User user) {
        return this.getUserId().compareTo(user.getUserId());
    }
}

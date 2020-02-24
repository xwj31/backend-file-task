package com.dekopay.model;

import java.util.Date;
import java.util.Objects;

public class UserRecord {

    private long userId;
    private String firstName;
    private String lastName;
    private String userName;
    private type userType;
    private Date lastLoginTime;

    public enum type {
        Employee,
        Manager,
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
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

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRecord that = (UserRecord) o;
        return getUserId() == that.getUserId() &&
                Objects.equals(getFirstName(), that.getFirstName()) &&
                Objects.equals(getLastName(), that.getLastName()) &&
                Objects.equals(getUserName(), that.getUserName()) &&
                getUserType() == that.getUserType() &&
                Objects.equals(getLastLoginTime(), that.getLastLoginTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getFirstName(), getLastName(), getUserName(), getUserType(), getLastLoginTime());
    }
}

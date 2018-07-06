package com.xq.live.backend.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xq.live.backend.persistence.beans.User;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ss on 2018/7/5.
 */
public class UserBo {

    private User user;

    public UserBo() {
        this.user = new User();
    }

    public UserBo(User user) {
        this.user = user;
    }

    @JsonIgnore
    public User getUser() {
        return this.user;
    }

    public Long getId() {
        return this.user.getId();
    }

    public void setId(Long id) {
        this.user.setId(id);
    }

    public String getUserName() {

        return this.user.getUserName();
    }

    public void setUserName(String userName) {
        this.user.setUserName(userName);
    }

    public String getPassword() {
        return this.user.getPassword();
    }

    public void setPassword(String password) {
        this.user.setPassword(password);
    }

    public String getNickName() {
        return this.user.getNickName();
    }

    public void setNickName(String nickName) {
        this.user.setNickName(nickName);
    }

    public String getIconUrl() {
        return this.user.getIconUrl();
    }

    public void setIconUrl(String iconUrl) {
        this.user.setIconUrl(iconUrl);
    }

    public String getMobile() {
        return this.user.getMobile();
    }

    public void setMobile(String mobile) {
        this.user.setMobile(mobile);
    }

    public BigDecimal getLocationX() {
        return this.user.getLocationX();
    }

    public void setLocationX(BigDecimal locationX) {
        this.user.setLocationX(locationX);
    }

    public BigDecimal getLocationY() {
        return this.user.getLocationY();
    }

    public void setLocationY(BigDecimal locationY) {
        this.user.setLocationY(locationY);
    }

    public Date getCreateTime() {
        return this.user.getCreateTime();
    }

    public void setCreateTime(Date createTime) {
        this.user.setCreateTime(createTime);
    }

    public Date getUpdateTime() {
        return this.user.getUpdateTime();
    }

    public void setUpdateTime(Date updateTime) {
        this.user.setUpdateTime(updateTime);
    }

    public Date getLastLoginTime() {
        return this.user.getLastLoginTime();
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.user.setLastLoginTime(lastLoginTime);
    }

    public String getUserIp() {
        return this.user.getUserIp();
    }

    public void setUserIp(String userIp) {
        this.user.setUserIp(userIp);
    }

    public Integer getLoginTimes() {
        return this.user.getLoginTimes();
    }

    public void setLoginTimes(Integer loginTimes) {
        this.user.setLoginTimes(loginTimes);
    }

    public Integer getSourceType() {
        return this.user.getSourceType();
    }

    public void setSourceType(Integer sourceType) {
        this.user.setSourceType(sourceType);
    }

    public Integer getUserType() {
        return this.user.getUserType();
    }

    public void setUserType(Integer userType) {
        this.user.setUserType(userType);
    }

    public Long getShopId() {
        return this.user.getShopId();
    }

    public void setShopId(Long shopId) {
        this.user.setShopId(shopId);
    }

    public String getOpenId() {
        return this.user.getOpenId();
    }

    public void setOpenId(String openId) {
        this.user.setOpenId(openId);
    }

    public String getUnionId() {
        return this.user.getUnionId();
    }

    public void setUnionId(String unionId) {
        this.user.setUnionId(unionId);
    }

    public Date getBirthday() {
        return this.user.getBirthday();
    }

    public void setBirthday(Date birthday) {
        this.user.setBirthday(birthday);
    }

    public Integer getSex() {
        return this.user.getSex();
    }

    public void setSex(Integer sex) {
        this.user.setSex(sex);
    }

    public Integer getAge() {
        return this.user.getAge();
    }

    public void setAge(Integer age) {
        this.user.setAge(age);
    }

    public Integer getHeight() {
        return this.user.getHeight();
    }

    public void setHeight(Integer height) {
        this.user.setHeight(height);
    }
}

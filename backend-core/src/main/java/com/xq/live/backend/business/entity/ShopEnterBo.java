package com.xq.live.backend.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xq.live.backend.framework.object.AbstractBO;
import com.xq.live.backend.persistence.beans.ShopEnter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ss on 2018/7/2.
 */
public class ShopEnterBo extends AbstractBO {

    private ShopEnter shopEnter;

    public ShopEnterBo() {
        this.shopEnter = new ShopEnter();
    }

    public ShopEnterBo(ShopEnter shopEnter) {
        this.shopEnter = shopEnter;
    }

    @JsonIgnore
    public ShopEnter getShopEnter() {
        return this.shopEnter;
    }


    public Long getId() {
        return this.shopEnter.getId();
    }

    public void setId(Long id) {
        this.shopEnter.setId(id);
    }

    public String getUserName() {
        return this.shopEnter.getUserName();
    }

    public void setUserName(String userName) {
        this.shopEnter.setUserName(userName);
    }

    public String getMobile() {
        return this.shopEnter.getMobile();
    }

    public void setMobile(String mobile) {
        this.shopEnter.setMobile(mobile);
    }

    public String getShopName() {
        return this.shopEnter.getShopName();
    }

    public void setShopName(String shopName) {
        this.shopEnter.setShopName(shopName);
    }

    public String getAddress() {
        return this.shopEnter.getAddress();
    }

    public void setAddress(String address) {
        this.shopEnter.setAddress(address);
    }

    public String getBusinessCate() {
        return this.shopEnter.getBusinessCate();
    }

    public void setBusinessCate(String businessCate) {
        this.shopEnter.setBusinessCate(businessCate);
    }

    public String getLicensePic() {
        return this.shopEnter.getLicensePic();
    }

    public void setLicensePic(String licensePic) {
        this.shopEnter.setLicensePic(licensePic);
    }

    public String getHealthPic() {
        return this.shopEnter.getHealthPic();
    }

    public void setHealthPic(String healthPic) {
        this.shopEnter.getHealthPic();
    }

    public String getDoorPic() {
        return this.shopEnter.getDoorPic();
    }

    public void setDoorPic(String doorPic) {
        this.shopEnter.setDoorPic(doorPic);
    }

    public Date getCreateTime() {
        return this.shopEnter.getCreateTime();
    }

    public void setCreateTime(Date createTime) {
        this.shopEnter.setCreateTime(createTime);
    }

    public Date getUpdateTime() {
        return this.shopEnter.getUpdateTime();
    }

    public void setUpdateTime(Date updateTime) {
        this.shopEnter.setUpdateTime(updateTime);
    }

    public Long getUserId() {
        return this.shopEnter.getUserId();
    }

    public void setUserId(Long userId) {
        this.shopEnter.setUserId(userId);
    }

    public Integer getStatus() {
        return this.shopEnter.getStatus();
    }

    public void setStatus(Integer status) {
        this.shopEnter.setStatus(status);
    }

    public BigDecimal getLocationX() {
        return this.shopEnter.getLocationX();
    }

    public void setLocationX(BigDecimal locationX) {
        this.shopEnter.setLocationX(locationX);
    }

    public BigDecimal getLocationY() {
        return this.shopEnter.getLocationY();
    }

    public void setLocationY(BigDecimal locationY) {
        this.shopEnter.setLocationY(locationY);
    }

    public String getCity() {
        return this.shopEnter.getCity();
    }

    public void setCity(String city) {
        this.shopEnter.setCity(city);
    }
}

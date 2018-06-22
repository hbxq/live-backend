package com.xq.live.backend.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xq.live.backend.framework.object.AbstractBO;
import com.xq.live.backend.persistence.beans.Shop;
import com.xq.live.backend.persistence.beans.SysRole;

import java.util.Date;

/**
 * com.xq.live.backend.business.entity
 *  商家业务对象bussiness object(BO）
 * @author zhangpeng32
 * Created on 2018/5/26 下午5:59
 * @Description:
 */
public class ShopBo{
    private Shop shop;

    public ShopBo() {
        this.shop = new Shop();
    }

    public ShopBo(Shop shop) {
        this.shop = shop;
    }

    @JsonIgnore
    public Shop getShop() {
        return this.shop;
    }

    public Long getId() {
        return this.shop.getId();
    }

    public void setId(Long id) {
        this.shop.setId(id);
    }

    public String getShopName() {
        return this.shop.getShopName();
    }

    public void setShopName(String shopName) {
        this.shop.setShopName(shopName);
    }

    public Integer getShopStatus() {
        return this.shop.getShopStatus();
    }

    public void setShopStatus(Integer shopStatus) {
        this.shop.setShopStatus(shopStatus);
    }


    public Date getCreateTime() {
        return this.shop.getCreateTime();
    }

    public void setCreateTime(Date createTime) {
        this.shop.setCreateTime(createTime);
    }

    public Date getUpdateTime() {
        return this.shop.getUpdateTime();
    }

    public void setUpdateTime(Date updateTime) {
        this.shop.setUpdateTime(updateTime);
    }

    public Integer getIsDeleted(){
        return this.shop.getIsDeleted();
    }

    public void setIsDeleted(Integer isDeleted){
        this.shop.setIsDeleted(isDeleted);
    }

    public Integer getApplyStatus(){
        return this.shop.getApplyStatus();
    }

    public void setApplyStatus(Integer applyStatus){
        this.shop.setApplyStatus(applyStatus);
    }

    public String getMobile(){
        return this.shop.getMobile();
    }

    public void setMobile(String mobile){
        this.shop.setMobile(mobile);
    }

    public String getAddress(){
        return this.shop.getAddress();
    }

    public void setAddress(String address){
        this.shop.setAddress(address);
    }

    public String getLogoUrl(){
        return this.shop.getLogoUrl();
    }

    public void setLogoUrl(String logoUrl){
        this.shop.setLogoUrl(logoUrl);
    }

    public String getCity() {return this.shop.getCity();}

    public void setCity(String city) {this.shop.setCity(city);}

    public String getShopInfo() {return this.shop.getShopInfo();}

    public void setShopInfo(String shopInfo) {this.shop.setShopInfo(shopInfo);}
}

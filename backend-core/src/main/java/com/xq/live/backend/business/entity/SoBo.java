package com.xq.live.backend.business.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xq.live.backend.framework.object.AbstractBO;
import com.xq.live.backend.persistence.beans.Shop;
import com.xq.live.backend.persistence.beans.So;
import com.xq.live.backend.persistence.beans.SoDetail;

import java.math.BigDecimal;
import java.util.Date;

/**
 * com.xq.live.backend.business.entity
 *  订单业务对象
 * @author zhangpeng32
 * Created on 2018/5/26 下午5:53
 * @Description:
 */
public class SoBo extends AbstractBO {
    private So so;

    public SoBo() {
        this.so = new So();
    }

    public SoBo(So so) {
        this.so = so;
    }

    @JsonIgnore
    public So getSo() {
        return this.so;
    }

    public Long getId() {
        return this.so.getId();
    }

    public void setId(Long id) {
        this.so.setId(id);
    }

    public BigDecimal getSoAmount() {
        return this.so.getSoAmount();
    }

    public void setSoAmount(BigDecimal soAmount) {
        this.so.setSoAmount(soAmount);
    }

    public Long getUserId() {
        return this.so.getUserId();
    }

    public void setUserId(Long userId) {
        this.so.setUserId(userId);
    }

    public String getUserName() {
        return this.so.getUserName();
    }

    public void setUserName(String userName) {
        this.so.setUserName(userName);
    }

    public Long getShopId() {
        return this.so.getShopId();
    }

    public void setShopId(Long shopId) {
        this.so.setShopId(shopId);
    }

    public Integer getPayType() {
        return this.so.getPayType();
    }

    public void setPayType(Integer payType) {
        this.so.setPayType(payType);
    }

    public Integer getSoStatus() {
        return this.so.getSoStatus();
    }

    public void setSoStatus(Integer soStatus) {
        this.so.setSoStatus(soStatus);
    }

    public Integer getSoType() {
        return this.so.getSoType();
    }

    public void setSoType(Integer soType) {
        this.so.setSoType(soType);
    }
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getPaidTime() {
        return this.so.getPaidTime();
    }

    public void setPaidTime(Date paidTime) {
        this.so.setPaidTime(paidTime);
    }
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getHxTime() {
        return this.so.getHxTime();
    }

    public void setHxTime(Date hxTime) {
        this.so.setHxTime(hxTime);
    }

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getCreateTime() {
        return this.so.getCreateTime();
    }

    public void setCreateTime(Date createTime) {
        this.so.setCreateTime(createTime);
    }
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getUpdateTime() {
        return this.so.getUpdateTime();
    }

    public void setUpdateTime(Date updateTime) {
        this.so.setUpdateTime(updateTime);
    }

    public Integer getIsDui() {
        return this.so.getIsDui();
    }

    public void setIsDui(Integer isDui) {
        this.so.setIsDui(isDui);
    }

    public String getShopName() {
        return this.so.getShopName();
    }

    public void setShopName(String shopName) {
        this.so.setShopName(shopName);
    }

    public Long getSkuId() {
        return this.so.getSkuId();
    }

    public void setSkuId(Long skuId) {
        this.setSkuId(skuId);
    }

    public BigDecimal getSellPrice() {
        return this.so.getSellPrice();
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.setSellPrice(sellPrice);
    }
    public BigDecimal getSoPrice() {
        return this.so.getSoPrice();
    }

    public void setSoPrice(BigDecimal soPrice) {
        this.setSoPrice(soPrice);
    }

    public Integer getPaymentMethod() {
        return this.so.getPaymentMethod();
    }

    public void setPaymentMethod(Integer paymentMethod) {
        this.setPaymentMethod(paymentMethod);
    }

    public BigDecimal getSoAllPrice() {
        return this.so.getSoAllPrice();
    }

    public void setSoAllPrice(BigDecimal soAllPrice) {
        this.setSoAllPrice(soAllPrice);
    }

}

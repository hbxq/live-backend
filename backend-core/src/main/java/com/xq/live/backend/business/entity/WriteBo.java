package com.xq.live.backend.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xq.live.backend.framework.object.AbstractBO;
import com.xq.live.backend.persistence.beans.So;
import com.xq.live.backend.persistence.beans.SoWriteOff;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ss on 2018/6/26.
 */
public class WriteBo extends AbstractBO {

    private SoWriteOff soWrite;

    public WriteBo() {
        this.soWrite = new SoWriteOff();
    }

    public WriteBo(SoWriteOff soWrite) {
        this.soWrite = soWrite;
    }

    @JsonIgnore
    public SoWriteOff getSoWriteOff() {
        return this.soWrite;
    }


    public Long getId() {
        return this.soWrite.getId();
    }

    public void setId(Long id) {
        this.soWrite.setId(id);
    }

    public Long getSoId() {
        return this.soWrite.getSoId();
    }

    public void setSoId(Long soId) {
        this.soWrite.setSoId(soId);
    }

    public Long getShopId() {
        return this.soWrite.getShopId();
    }

    public void setShopId(Long shopId) {
        this.soWrite.setShopId(shopId);
    }

    public String getShopName() {
        return this.soWrite.getShopName();
    }

    public void setShopName(String shopName) {
        this.soWrite.setShopName(shopName);
    }

    public BigDecimal getShopAmount() {
        return this.soWrite.getShopAmount();
    }

    public void setShopAmount(BigDecimal shopAmount) {
        this.soWrite.setShopAmount(shopAmount);
    }

    public Long getCouponId() {
        return this.soWrite.getCouponId();
    }

    public void setCouponId(Long couponId) {
        this.soWrite.setCouponId(couponId);
    }

    public String getCouponCode() {
        return this.soWrite.getCouponCode();
    }

    public void setCouponCode(String couponCode) {
        this.soWrite.setCouponCode(couponCode);
    }

    public Long getSkuId() {
        return this.soWrite.getSkuId();
    }

    public void setSkuId(Long skuId) {
        this.soWrite.setSkuId(skuId);
    }

    public BigDecimal getCouponAmount() {
        return this.soWrite.getCouponAmount();
    }

    public void setCouponAmount(BigDecimal couponAmount) {
        this.soWrite.setCouponAmount(couponAmount);
    }

    public Long getUserId() {
        return this.soWrite.getUserId();
    }

    public void setUserId(Long userId) {
        this.soWrite.setUserId(userId);
    }

    public String getUserName() {
        return this.soWrite.getUserName();
    }

    public void setUserName(String userName) {
        this.soWrite.setUserName(userName);
    }

    public Long getCashierId() {
        return this.soWrite.getCashierId();
    }

    public void setCashierId(Long cashierId) {
        this.soWrite.setCashierId(cashierId);
    }

    public String getCashierName() {
        return this.soWrite.getCashierName();
    }

    public void setCashierName(String cashierName) {
        this.soWrite.setCashierName(cashierName);
    }

    public BigDecimal getPaidAmount() {
        return this.soWrite.getPaidAmount();
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.soWrite.setPaidAmount(paidAmount);
    }

    public Date getCreateTime() {
        return this.soWrite.getCreateTime();
    }

    public void setCreateTime(Date createTime) {
        this.soWrite.setCreateTime(createTime);
    }

    public Date getUpdateTime() {
        return this.soWrite.getUpdateTime();
    }

    public void setUpdateTime(Date updateTime) {
        this.soWrite.setUpdateTime(updateTime);
    }



    public Integer getIsBill() {
        return this.soWrite.getIsBill();
    }

    public void setIsBill(Integer isBill) {
        this.soWrite.setIsBill(isBill);
    }

    public SoWriteOff getSoWrite() {
        return soWrite;
    }

    public void setSoWrite(SoWriteOff soWrite) {
        this.soWrite = soWrite;
    }

    public BigDecimal getSoPrice() {
        return this.soWrite.getSoPrice();
    }

    public void setSoPrice(BigDecimal soPrice) {
        this.soWrite.setSoPrice(soPrice);
    }

    public BigDecimal getSellPrice() {
        return this.soWrite.getSellPrice();
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.soWrite.setSellPrice(sellPrice);
    }

    public So getParent() {
        return this.soWrite.getSo();
    }

    public void setParent(So so) {
        this.soWrite.setSo(so);
    }

    public BigDecimal getTotalPrice() {
        return this.soWrite.getTotalPrice();
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.soWrite.setTotalPrice(totalPrice);
    }

    public BigDecimal getTotalService() {
        return this.soWrite.getTotalService();
    }

    public void setTotalService(BigDecimal totalService) {
        this.soWrite.setTotalService(totalService);
    }

    public Integer getSoType() {
        return this.soWrite.getSoType();
    }

    public void setSoType(Integer soType) {
        this.soWrite.setSoType(soType);
    }

    public BigDecimal getSoAmount() {
        return this.soWrite.getSoAmount();
    }

    public void setSoAmount(BigDecimal soAmount) {
        this.soWrite.setSoAmount(soAmount);
    }
}

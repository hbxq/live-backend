package com.xq.live.backend.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xq.live.backend.framework.object.AbstractBO;
import com.xq.live.backend.persistence.beans.ServiceAmount;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ss on 2018/7/28.
 */
public class ServiceAmountBo extends AbstractBO {
    private ServiceAmount serviceAmount;

    public ServiceAmountBo() {
        this.serviceAmount = new ServiceAmount();
    }

    public ServiceAmountBo(ServiceAmount serviceAmount) {
        this.serviceAmount = serviceAmount;
    }

    @JsonIgnore
    public ServiceAmount getSo() {
        return this.serviceAmount;
    }


    public Long getId() {
        return this.serviceAmount.getId();
    }

    public void setId(Long id) {
        this.serviceAmount.setId(id);
    }

    public Date getCreateTime() {
        return this.serviceAmount.getCreateTime();
    }

    public void setCreateTime(Date createTime) {
        this.serviceAmount.setCreateTime(createTime);
    }

    public Date getUpdateTime() {
        return this.serviceAmount.getUpdateTime();
    }

    public void setUpdateTime(Date updateTime) {
        this.serviceAmount.setUpdateTime(updateTime);
    }

    public Long getPaidUserId() {
        return this.serviceAmount.getPaidUserId();
    }

    public void setPaidUserId(Long paidUserId) {
        this.serviceAmount.setPaidUserId(paidUserId);
    }

    public Long getShopId() {
        return this.serviceAmount.getShopId();
    }

    public void setShopId(Long shopId) {
        this.serviceAmount.setShopId(shopId);
    }

    public BigDecimal getServicePrice() {
        return this.serviceAmount.getServicePrice();
    }

    public void setServicePrice(BigDecimal servicePrice) {
        this.serviceAmount.setServicePrice(servicePrice);
    }

    public Date getBeginTime() {
        return this.serviceAmount.getBeginTime();
    }

    public void setBeginTime(Date beginTime) {
        this.serviceAmount.setBeginTime(beginTime);
    }

    public Date getEndTime() {
        return this.serviceAmount.getEndTime();
    }

    public void setEndTime(Date endTime) {
        this.serviceAmount.setEndTime(endTime);
    }
}

package com.xq.live.backend.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xq.live.backend.framework.object.AbstractBO;
import com.xq.live.backend.persistence.beans.ShopAllocation;

import java.util.Date;

/**
 * 商家配置
 * Created by ss on 2018/7/2.
 */
public class ShopAllocationBo extends AbstractBO {
    private ShopAllocation shopAllocation;

    public ShopAllocationBo() {
        this.shopAllocation = new ShopAllocation();
    }

    public ShopAllocationBo(ShopAllocation shopAllocation) {
        this.shopAllocation = shopAllocation;
    }

    @JsonIgnore
    public ShopAllocation getShopAllocation() {
        return this.shopAllocation;
    }


    public Long getId() {
        return this.shopAllocation.getId();
    }

    public void setId(Long id) {
        this.shopAllocation.setId(id);
    }

    public Long getShopId() {
        return this.shopAllocation.getShopId();
    }

    public void setShopId(Long shopId) {
        this.shopAllocation.setShopId(shopId);
    }

    public Long getOperatorId() {
        return this.shopAllocation.getOperatorId();
    }

    public void setOperatorId(Long operatorId) {
        this.shopAllocation.setOperatorId(operatorId);
    }

    public Integer getIsDelete() {
        return this.shopAllocation.getIsDelete();
    }

    public void setIsDelete(Integer isDelete) {
        this.shopAllocation.setIsDelete(isDelete);
    }

    public Date getCreateTime() {
        return this.shopAllocation.getCreateTime();
    }

    public void setCreateTime(Date createTime) {
        this.shopAllocation.setCreateTime(createTime);
    }

    public Date getUpdateTime() {
        return this.shopAllocation.getUpdateTime();
    }

    public void setUpdateTime(Date updateTime) {
        this.shopAllocation.setUpdateTime(updateTime);
    }

    public Integer getPaymentMethod() {
        return this.shopAllocation.getPaymentMethod();
    }

    public void setPaymentMethod(Integer paymentMethod) {
        this.shopAllocation.setPaymentMethod(paymentMethod);
    }
}

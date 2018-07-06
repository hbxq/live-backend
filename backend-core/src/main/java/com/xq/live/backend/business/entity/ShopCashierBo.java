package com.xq.live.backend.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xq.live.backend.framework.object.AbstractBO;
import com.xq.live.backend.persistence.beans.ShopCashier;

import java.util.Date;

/**
 * Created by ss on 2018/7/2.
 */
public class ShopCashierBo extends AbstractBO {

    private ShopCashier shopCashier;

    public ShopCashierBo() {
        this.shopCashier = new ShopCashier();
    }

    public ShopCashierBo(ShopCashier shopCashier) {
        this.shopCashier = shopCashier;
    }

    @JsonIgnore
    public ShopCashier getShopCashier() {
        return this.shopCashier;
    }



    public Long getId() {
        return this.shopCashier.getId();
    }

    public void setId(Long id) {
        this.shopCashier.setId(id);
    }

    public Long getCashierId() {
        return this.shopCashier.getCashierId();
    }

    public void setCashierId(Long cashierId) {
        this.shopCashier.setCashierId(cashierId);
    }

    public String getCashierName() {
        return this.shopCashier.getCashierName();
    }

    public void setCashierName(String cashierName) {
        this.shopCashier.setCashierName(cashierName);
    }

    public String getPassword() {
        return this.shopCashier.getPassword();
    }

    public void setPassword(String password) {
        this.shopCashier.setPassword(password);
    }

    public Long getShopId() {
        return this.shopCashier.getShopId();
    }

    public void setShopId(Long shopId) {
        this.shopCashier.setShopId(shopId);
    }

    public Long getParentId() {
        return this.shopCashier.getParentId();
    }

    public void setParentId(Long parentId) {
        this.shopCashier.setParentId(parentId);
    }

    public Byte getIsAdmin() {
        return this.shopCashier.getIsAdmin();
    }

    public void setIsAdmin(Byte isAdmin) {
        this.shopCashier.setIsAdmin(isAdmin);
    }

    public Byte getIsDeleted() {
        return this.shopCashier.getIsDeleted();
    }

    public void setIsDeleted(Byte isDeleted) {
        this.shopCashier.setIsDeleted(isDeleted);
    }

    public Date getCreateTime() {
        return this.shopCashier.getCreateTime();
    }

    public void setCreateTime(Date createTime) {
        this.shopCashier.setCreateTime(createTime);
    }

    public Long getCreatorId() {
        return this.shopCashier.getCreatorId();
    }

    public void setCreatorId(Long creatorId) {
        this.shopCashier.setCreatorId(creatorId);
    }

    public Long getUpdatorId() {
        return this.shopCashier.getUpdatorId();
    }

    public void setUpdatorId(Long updatorId) {
        this.shopCashier.setUpdatorId(updatorId);
    }

    public Date getUpdateTime() {
        return this.shopCashier.getUpdateTime();
    }

    public void setUpdateTime(Date updateTime) {
        this.shopCashier.setUpdateTime(updateTime);
    }

}

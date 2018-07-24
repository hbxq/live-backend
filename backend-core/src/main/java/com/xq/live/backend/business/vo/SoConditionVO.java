package com.xq.live.backend.business.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xq.live.backend.framework.object.BaseConditionVO;
import com.xq.live.backend.persistence.beans.So;
import com.xq.live.backend.persistence.beans.SoDetail;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * com.xq.live.backend.business.vo
 *
 * @author zhangpeng32
 * Created on 2018/5/26 下午4:14
 * @Description:
 */
@EqualsAndHashCode(callSuper = false)
public class SoConditionVO extends BaseConditionVO {

    private BigDecimal soAmount;
    private Long userId;
    private String userName;
    private Long shopId;
    private Integer payType;
    private Integer soStatus;
    private Integer soType;
    private Date paidTime;
    private Date hxTime;
    private Integer isDui;

    private Long id;
    private Date createTime;
    private Date updateTime;


    public BigDecimal getSoAmount() {
        return soAmount;
    }

    public void setSoAmount(BigDecimal soAmount) {
        this.soAmount = soAmount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getSoStatus() {
        return soStatus;
    }

    public void setSoStatus(Integer soStatus) {
        this.soStatus = soStatus;
    }

    public Integer getSoType() {
        return soType;
    }

    public void setSoType(Integer soType) {
        this.soType = soType;
    }

    public Date getPaidTime() {
        return paidTime;
    }

    public void setPaidTime(Date paidTime) {
        this.paidTime = paidTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getHxTime() {
        return hxTime;
    }

    public void setHxTime(Date hxTime) {
        this.hxTime = hxTime;
    }

    public Integer getIsDui() {
        return isDui;
    }

    public void setIsDui(Integer isDui) {
        this.isDui = isDui;
    }
}

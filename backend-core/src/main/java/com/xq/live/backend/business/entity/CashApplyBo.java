package com.xq.live.backend.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xq.live.backend.framework.object.AbstractBO;
import com.xq.live.backend.persistence.beans.CashApply;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ss on 2018/7/19.
 */
public class CashApplyBo  extends AbstractBO {

    private CashApply cashApply;

    public CashApplyBo() {
        this.cashApply = new CashApply();
    }

    public CashApplyBo(CashApply cashApply) {
        this.cashApply = cashApply;
    }

    @JsonIgnore
    public CashApply getCashApply() {
        return this.cashApply;
    }

    public Long getId() {
        return this.cashApply.getId();
    }

    public void setId(Long id) {
        this.cashApply.setId(id);
    }

    public Date getCreateTime() {
        return this.cashApply.getCreateTime();
    }

    public void setCreateTime(Date createTime) {
        this.cashApply.setCreateTime(createTime);
    }

    public Date getUpdateTime() {
        return this.cashApply.getUpdateTime();
    }

    public void setUpdateTime(Date updateTime) {
        this.cashApply.setUpdateTime(updateTime);
    }

    public Long getUserId() {
        return this.cashApply.getUserId();
    }

    public void setUserId(Long userId) {
        this.cashApply.setUserId(userId);
    }

    public Long getAccountId() {
        return this.cashApply.getAccountId();
    }

    public void setAccountId(Long accountId) {
        this.cashApply.setAccountId(accountId);
    }

    public String getUserName() {
        return this.cashApply.getUserName();
    }

    public void setUserName(String userName) {
        this.cashApply.setUserName(userName);
    }

    public BigDecimal getCashAmount() {
        return this.cashApply.getCashAmount();
    }

    public void setCashAmount(BigDecimal cashAmount) {
        this.cashApply.setCashAmount(cashAmount);
    }

    public String getAccountName() {
        return this.cashApply.getAccountName();
    }

    public void setAccountName(String accountName) {
        this.cashApply.setAccountName(accountName);
    }

    public Byte getApplyStatus() {
        return this.cashApply.getApplyStatus();
    }

    public void setApplyStatus(Byte applyStatus) {
        this.cashApply.setApplyStatus(applyStatus);
    }

    public Date getPaidTime() {
        return this.cashApply.getPaidTime();
    }

    public void setPaidTime(Date paidTime) {
        this.cashApply.setPaidTime(paidTime);
    }

    public Long getPaidUserId() {
        return this.cashApply.getPaidUserId();
    }

    public void setPaidUserId(Long paidUserId) {
        this.cashApply.setPaidUserId(paidUserId);
    }

    public String getPaidUserName() {
        return this.cashApply.getPaidUserName();
    }

    public void setPaidUserName(String paidUserName) {
        this.cashApply.setPaidUserName(paidUserName);
    }

    public String getNickName() {
        return this.cashApply.getNickName();
    }

    public void setNickName(String nickName) {
        this.cashApply.setNickName(nickName);
    }

    public String getMobile() {
        return this.cashApply.getMobile();
    }

    public void setMobile(String mobile) {
        this.cashApply.setMobile(mobile);
    }
}

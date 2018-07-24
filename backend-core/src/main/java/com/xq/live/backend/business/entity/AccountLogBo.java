package com.xq.live.backend.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xq.live.backend.framework.object.AbstractBO;
import com.xq.live.backend.persistence.beans.AccountLog;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ss on 2018/7/18.
 */
public class AccountLogBo extends AbstractBO {
    private AccountLog accountLog;

    public AccountLogBo() {
        this.accountLog = new AccountLog();
    }

    public AccountLogBo(AccountLog accountLog) {
        this.accountLog = accountLog;
    }

    @JsonIgnore
    public AccountLog getAccountLog() {
        return this.accountLog;
    }


    public Long getId() {
        return this.accountLog.getId();
    }

    public void setId(Long id) {
        this.accountLog.setId(id);
    }

    public Date getCreateTime() {
        return this.accountLog.getCreateTime();
    }

    public void setCreateTime(Date createTime) {
        this.accountLog.setCreateTime(createTime);
    }

    public Date getUpdateTime() {
        return this.accountLog.getUpdateTime();
    }

    public void setUpdateTime(Date updateTime) {
        this.accountLog.setUpdateTime(updateTime);
    }

    public Long getUserId() {
        return this.accountLog.getUserId();
    }

    public void setUserId(Long userId) {
        this.accountLog.setUserId(userId);
    }

    public String getUserName() {
        return this.accountLog.getUserName();
    }

    public void setUserName(String userName) {
        this.accountLog.setUserName(userName);
    }

    public Long getAccountId() {
        return this.accountLog.getAccountId();
    }

    public void setAccountId(Long accountId) {
        this.accountLog.setAccountId(accountId);
    }

    public String getAccountName() {
        return this.accountLog.getAccountName();
    }

    public void setAccountName(String accountName) {
        this.accountLog.setAccountName(accountName);
    }

    public BigDecimal getPreAmount() {
        return this.accountLog.getPreAmount();
    }

    public void setPreAmount(BigDecimal preAmount) {
        this.accountLog.setPreAmount(preAmount);
    }

    public BigDecimal getAfterAmount() {
        return this.accountLog.getAfterAmount();
    }

    public void setAfterAmount(BigDecimal afterAmount) {
        this.accountLog.setAfterAmount(afterAmount);
    }

    public BigDecimal getOperateAmount() {
        return this.accountLog.getOperateAmount();
    }

    public void setOperateAmount(BigDecimal operateAmount) {
        this.accountLog.setOperateAmount(operateAmount);
    }

    public Integer getOperateType() {
        return this.accountLog.getOperateType();
    }

    public void setOperateType(Integer operateType) {
        this.accountLog.setOperateType(operateType);
    }

    public String getRemark() {
        return this.accountLog.getRemark();
    }

    public void setRemark(String remark) {
        this.accountLog.setRemark(remark);
    }
}

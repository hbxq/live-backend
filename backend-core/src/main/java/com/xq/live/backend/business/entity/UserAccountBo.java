package com.xq.live.backend.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.mail.imap.ACL;
import com.xq.live.backend.framework.object.AbstractBO;
import com.xq.live.backend.persistence.beans.UserAccount;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ss on 2018/7/18.
 */
public class UserAccountBo extends AbstractBO {

    private UserAccount userAccount;

    public UserAccountBo() {
        this.userAccount = new UserAccount();
    }

    public UserAccountBo(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    @JsonIgnore
    public UserAccount getAccountLog() {
        return this.userAccount;
    }

    public Long getId() {
        return this.userAccount.getId();
    }

    public void setId(Long id) {
        this.userAccount.setId(id);
    }

    public Date getCreateTime() {
        return this.userAccount.getCreateTime();
    }

    public void setCreateTime(Date createTime) {
        this.userAccount.setCreateTime(createTime);
    }

    public Date getUpdateTime() {
        return this.userAccount.getUpdateTime();
    }

    public void setUpdateTime(Date updateTime) {
        this.userAccount.setUpdateTime(updateTime);
    }

    public Long getUserId() {
        return this.userAccount.getUserId();
    }

    public void setUserId(Long userId) {
        this.userAccount.setUserId(userId);
    }

    public String getUserName() {
        return this.userAccount.getUserName();
    }

    public void setUserName(String userName) {
        this.userAccount.setUserName(userName);
    }

    public String getAccountName() {
        return this.userAccount.getAccountName();
    }

    public void setAccountName(String accountName) {
        this.userAccount.setAccountName(accountName);
    }

    public Integer getAccountType() {
        return this.userAccount.getAccountType();
    }

    public void setAccountType(Integer accountType) {
        this.userAccount.setAccountType(accountType);
    }

    public BigDecimal getAccountAmount() {
        return this.userAccount.getAccountAmount();
    }

    public void setAccountAmount(BigDecimal accountAmount) {
        this.userAccount.setAccountAmount(accountAmount);
    }

    public Integer getAccountStatus() {
        return this.userAccount.getAccountStatus();
    }

    public void setAccountStatus(Integer accountStatus) {
        this.userAccount.setAccountStatus(accountStatus);
    }

    public Integer getIsDeleted() {
        return this.userAccount.getIsDeleted();
    }

    public void setIsDeleted(Integer isDeleted) {
        this.userAccount.setIsDeleted(isDeleted);
    }

    public Integer getVersionNo() {
        return this.userAccount.getVersionNo();
    }

    public void setVersionNo(Integer versionNo) {
        this.userAccount.setVersionNo(versionNo);
    }
}

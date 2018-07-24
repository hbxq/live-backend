package com.xq.live.backend.business.vo;

import com.xq.live.backend.framework.object.BaseConditionVO;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ss on 2018/7/18.
 */
public class UserAccountConditionVO extends BaseConditionVO {

    private Long id;
    private Date createTime;
    private Date updateTime;

    private Long userId;    //用户表ID
    private String userName;    //用户账号
    private String accountName;    //支付账号
    private Integer accountType;   //账户类型 0 享七  1 微信  2支付宝
    private BigDecimal accountAmount;   //账户余额
    private Integer accountStatus; //账户状态 1 正常 2 冻结
    private Integer isDeleted;     //是否删除 0 否 1 是
    private Integer versionNo;  //版本号


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

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getAccountAmount() {
        return accountAmount;
    }

    public void setAccountAmount(BigDecimal accountAmount) {
        this.accountAmount = accountAmount;
    }

    public Integer getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Integer accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(Integer versionNo) {
        this.versionNo = versionNo;
    }
}

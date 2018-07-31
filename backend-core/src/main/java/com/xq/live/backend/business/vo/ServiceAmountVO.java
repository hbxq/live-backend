package com.xq.live.backend.business.vo;

import com.xq.live.backend.framework.object.BaseConditionVO;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ss on 2018/7/28.
 */
@EqualsAndHashCode(callSuper = false)
public class ServiceAmountVO extends BaseConditionVO {

    private Long id;
    private Date createTime;
    private Date updateTime;

    private Long paidUserId;
    private Long shopId;
    private BigDecimal servicePrice;
    private Date beginTime;
    private Date endTime;


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

    public Long getPaidUserId() {
        return paidUserId;
    }

    public void setPaidUserId(Long paidUserId) {
        this.paidUserId = paidUserId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public BigDecimal getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(BigDecimal servicePrice) {
        this.servicePrice = servicePrice;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}

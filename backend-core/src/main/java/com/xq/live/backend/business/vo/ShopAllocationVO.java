package com.xq.live.backend.business.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xq.live.backend.framework.object.BaseConditionVO;

import java.util.Date;

/**
 * Created by ss on 2018/7/2.
 */
public class ShopAllocationVO  extends BaseConditionVO {

   /* @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date beginTime;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date endTime;*/

    private Long id;
    private Date createTime;
    private Date updateTime;

    private Long shopId;
    private Long operatorId;
    private Integer isDelete;
    private Integer paymentMethod;

   /* public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }*/

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

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public Integer getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Integer paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}

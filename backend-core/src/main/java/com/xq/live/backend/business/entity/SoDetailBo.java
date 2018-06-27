package com.xq.live.backend.business.entity;

import com.xq.live.backend.framework.object.AbstractBO;
import com.xq.live.backend.persistence.beans.SoDetail;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单详情业务对象
 * Created by lipeng on 2018/6/27.
 */
public class SoDetailBo extends AbstractBO {
    private SoDetail soDetail;


    public SoDetailBo(){this.soDetail = new SoDetail();}

    public SoDetailBo(SoDetail soDetail){this.soDetail = soDetail;}

    @JsonIgnore
    public SoDetail getSoDetail(){
        return this.soDetail;
    }

    public Long getId() {
        return this.soDetail.getId();
    }

    public void setId(Long id) {
        this.soDetail.setId(id);
    }

    public Long getSoId() {
        return this.soDetail.getSoId();
    }

    public void setSoId(Long soId) {
        this.soDetail.setSoId(soId);
    }

    public Long getSkuId() {
        return this.soDetail.getSkuId();
    }

    public void setSkuId(Long skuId) {
        this.soDetail.setSkuId(skuId);
    }

    public String getSkuCode() {
        return this.soDetail.getSkuCode();
    }

    public void setSkuCode(String skuCode) {
        this.soDetail.setSkuCode(skuCode);
    }

    public String getSkuName() {
        return this.soDetail.getSkuName();
    }

    public void setSkuName(String skuName) {
        this.soDetail.setSkuName(skuName);
    }

    public Integer getSkuNum() {
        return this.soDetail.getSkuNum();
    }

    public void setSkuNum(Integer skuNum) {
        this.soDetail.setSkuNum(skuNum);
    }

    public BigDecimal getUnitPrice() {
        return this.soDetail.getUnitPrice();
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.soDetail.setUnitPrice(unitPrice);
    }

    public Date getCreateTime() {
        return this.soDetail.getCreateTime();
    }

    public void setCreateTime(Date createTime) {
        this.soDetail.setCreateTime(createTime);
    }

    public Date getUpdateTime() {
        return this.soDetail.getUpdateTime();
    }

    public void setUpdateTime(Date updateTime) {
        this.soDetail.setUpdateTime(updateTime);
    }
}

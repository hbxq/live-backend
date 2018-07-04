package com.xq.live.backend.business.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xq.live.backend.framework.object.BaseConditionVO;
import com.xq.live.backend.persistence.beans.SoWriteOff;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

//@Data
@EqualsAndHashCode(callSuper = false)
public class SoWriteOffInVo extends BaseConditionVO {
   //private SoWriteOff soWrite;

   @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
   private Date beginTime;
   @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
   private Date endTime;


   private Long id;
   private Date createTime;//等同于核销时间
   private Date updateTime;

   private Long soId;
   private Long shopId;
   private String shopName;
   private BigDecimal shopAmount;
   private Long couponId;
   private String couponCode;
   private Long skuId;
   private BigDecimal couponAmount;//卷面值
   private Long userId;//卷所属订单的userId
   private String userName;//卷所属订单的userId
   private Long cashierId;//收银员的id---当前操作的用户id
   private String cashierName;
   private BigDecimal paidAmount;//支付金额(已经减去了卷面值的)
   private Integer isBill;//是否对账 0未对账 1对账

   private BigDecimal totalPrice;//总营业额
   private BigDecimal totalService;//总服务费
   private BigDecimal soPrice;//單筆訂單服務費
   private BigDecimal sellPrice;//平臺服務費
   private Integer soType;//订单类型

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

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Date getUpdateTime() {
      return updateTime;
   }

   public void setUpdateTime(Date updateTime) {
      this.updateTime = updateTime;
   }

   public Date getCreateTime() {
      return createTime;
   }

   public void setCreateTime(Date createTime) {
      this.createTime = createTime;
   }

   public Long getSoId() {
      return soId;
   }

   public void setSoId(Long soId) {
      this.soId = soId;
   }

   public Long getShopId() {
      return shopId;
   }

   public void setShopId(Long shopId) {
      this.shopId = shopId;
   }

   public String getShopName() {
      return shopName;
   }

   public void setShopName(String shopName) {
      this.shopName = shopName;
   }

   public BigDecimal getShopAmount() {
      return shopAmount;
   }

   public void setShopAmount(BigDecimal shopAmount) {
      this.shopAmount = shopAmount;
   }

   public Long getCouponId() {
      return couponId;
   }

   public void setCouponId(Long couponId) {
      this.couponId = couponId;
   }

   public String getCouponCode() {
      return couponCode;
   }

   public void setCouponCode(String couponCode) {
      this.couponCode = couponCode;
   }

   public Long getSkuId() {
      return skuId;
   }

   public void setSkuId(Long skuId) {
      this.skuId = skuId;
   }

   public BigDecimal getCouponAmount() {
      return couponAmount;
   }

   public void setCouponAmount(BigDecimal couponAmount) {
      this.couponAmount = couponAmount;
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

   public Long getCashierId() {
      return cashierId;
   }

   public void setCashierId(Long cashierId) {
      this.cashierId = cashierId;
   }

   public String getCashierName() {
      return cashierName;
   }

   public void setCashierName(String cashierName) {
      this.cashierName = cashierName;
   }

   public BigDecimal getPaidAmount() {
      return paidAmount;
   }

   public void setPaidAmount(BigDecimal paidAmount) {
      this.paidAmount = paidAmount;
   }

   public Integer getIsBill() {
      return isBill;
   }

   public void setIsBill(Integer isBill) {
      this.isBill = isBill;
   }

   public BigDecimal getTotalService() {
      return totalService;
   }

   public void setTotalService(BigDecimal totalService) {
      this.totalService = totalService;
   }

   public BigDecimal getSoPrice() {
      return soPrice;
   }

   public void setSoPrice(BigDecimal soPrice) {
      this.soPrice = soPrice;
   }

   public Integer getSo_type() {
      return soType;
   }

   public void setSo_type(Integer so_type) {
      this.soType = so_type;
   }

   public BigDecimal getSellPrice() {
      return sellPrice;
   }

   public void setSellPrice(BigDecimal sellPrice) {
      this.sellPrice = sellPrice;
   }

   public BigDecimal getTotalPrice() {
      return totalPrice;
   }

   public void setTotalPrice(BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
   }
}
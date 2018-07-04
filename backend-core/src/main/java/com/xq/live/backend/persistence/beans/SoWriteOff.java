package com.xq.live.backend.persistence.beans;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xq.live.backend.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "so_write_off")
public class SoWriteOff extends AbstractDO {

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

    @Transient
    private BigDecimal totalPrice;//总营业额
    @Transient
    private BigDecimal totalService;//总服务费
    @Transient
    private BigDecimal soPrice;//單筆訂單服務費
    @Transient
    private BigDecimal sellPrice;//平臺服務費
    @Transient
    private Integer soType;//订单类型
    @Transient
    private BigDecimal soAmount;//订单类型
    @Transient
    private So so;


}

package com.xq.live.backend.persistence.beans;

import com.xq.live.backend.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;

/**
 * com.xq.live.backend.persistence.beans
 *
 * @author zhangpeng32
 * Created on 2018/5/26 下午4:07
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "so")
public class So extends AbstractDO {
    //订单状态 1待支付 2 已支付 3已核销 10取消
    public final static int SO_STATUS_WAIT_PAID = 1;
    public final static int SO_STATUS_PAID = 2;
    public final static int SO_STATUS_APPLIED = 3;
    public final static int SO_STATUS_CANCEL = 10;

    //订单类型 1 普通订单(平台订单)   2 商家订单
    public final static int SO_TYPE_PT = 1;

    public final static int SO_TYPE_SJ = 2;

    //支付方式 1 享七支付  2微信支付
    public final static int SO_PAY_TYPE_XQ = 1;

    public final static int SO_PAY_TYPE_WX = 2;

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

    @Transient
    private SoDetail soDetail;
    @Transient
    private String shopName;
}

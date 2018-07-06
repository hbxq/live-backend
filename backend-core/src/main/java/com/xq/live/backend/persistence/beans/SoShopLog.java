package com.xq.live.backend.persistence.beans;

import com.xq.live.backend.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;
/*
* 商家订单关联
* */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "so_shop_log")
public class SoShopLog extends AbstractDO{
    private Long soId;

    private Long shopId;

    private Long skuId;

    private Long userId;

    private String userName;

    private Integer operateType;

    private String userIp;
}

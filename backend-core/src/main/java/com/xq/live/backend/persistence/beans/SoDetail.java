package com.xq.live.backend.persistence.beans;

import com.xq.live.backend.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;
import java.math.BigDecimal;
/*
* 订单明细
* */


@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "so_detail")
public class SoDetail extends AbstractDO {
    private Long soId;
    private Long skuId;
    private String skuCode;
    private String skuName;
    private Integer skuNum;
    private BigDecimal unitPrice;
}

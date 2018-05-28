package com.xq.live.backend.persistence.beans;

import com.xq.live.backend.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * com.xq.live.backend.persistence.beans
 *
 * @author zhangpeng32
 * Created on 2018/5/26 下午4:11
 * @Description:
 */
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

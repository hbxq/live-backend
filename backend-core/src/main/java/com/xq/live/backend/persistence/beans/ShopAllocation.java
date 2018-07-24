package com.xq.live.backend.persistence.beans;

import com.xq.live.backend.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.Table;
import java.util.Date;
/*
*商家配置（是否平台代收）
* */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "shop_allocation")
public class ShopAllocation extends AbstractDO {

    /**
     * paymentMethod  1 商家自收  2 平台代收
     */
    public final static int SHOP_ALLOCATION_ZS = 1;

    public final static int SHOP_ALLOCATION_DS = 2;

    /**
     * 是否删除  0 未删除  1 删除
     */
    public final static int SHOP_ALLOCATION_NO_DELETED = 0;

    public final static int SHOP_ALLOCATION_IS_DELETED = 1;

    private Long shopId;
    private Long operatorId;
    private Integer isDelete;
    private Integer paymentMethod;

}

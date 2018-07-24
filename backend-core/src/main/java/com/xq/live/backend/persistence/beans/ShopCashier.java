package com.xq.live.backend.persistence.beans;

import com.xq.live.backend.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;
import java.util.Date;
/*
*
* 商家管理员配置
* */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "shop_cashier")
public class ShopCashier  extends AbstractDO {
    /**
     * is_deleted 0 未删除  1 已删除
     */
    public final static byte SHOP_CASHIER_NO_DELETED = 0;

    public final static byte SHOP_CASHIER_IS_DELETED = 1;
    /**
     * is_admin 0 不是管理员  1 管理员
     */
    public final static byte SHOP_CASHIER_NO_ADMIN = 0;

    public final static byte SHOP_CASHIER_IS_ADMIN = 1;

    private Long cashierId;
    private String cashierName;
    private String password;
    private Long shopId;
    private Long parentId;
    private Byte isAdmin;
    private Byte isDeleted;
    private Long creatorId;
    private Long updatorId;



}

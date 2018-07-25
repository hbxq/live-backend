package com.xq.live.backend.persistence.beans;

import com.xq.live.backend.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ss on 2018/7/18.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "user_account")
public class UserAccount extends AbstractDO {

    /**
     * 用户账户类型 0 享七 1 微信 2 支付宝
     */
    public final static int ACCOUNT_TYPE_XQ = 0;

    public final static int ACCOUNT_TYPE_WX = 1;

    public final static int ACCOUNT_TYPE_ZFB = 2;

    /**
     * 账户状态  1 正常 2 冻结
     */
    public final static int ACCOUNT_STATUS_ACTIVE = 1;

    public final static int ACCOUNT_STATUS_FROZEN = 2;



    private Long userId;    //用户表ID
    private String userName;    //用户账号
    private String accountName;    //支付账号
    private Integer accountType;   //账户类型 0 享七  1 微信  2支付宝
    private BigDecimal accountAmount;   //账户余额
    private Integer accountStatus; //账户状态 1 正常 2 冻结
    private Integer isDeleted;     //是否删除 0 否 1 是
    private Integer versionNo;  //版本号

}

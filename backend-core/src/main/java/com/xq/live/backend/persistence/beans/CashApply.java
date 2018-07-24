package com.xq.live.backend.persistence.beans;

import com.xq.live.backend.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ss on 2018/7/19.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "cash_apply")
public class CashApply  extends AbstractDO {


    @NotNull(message = "userId必填")
    private Long userId;
    @NotNull(message = "userName必填")
    private String userName;
    private Long accountId;
    private String accountName;
    @NotNull(message = "cashAmount必填")
    private BigDecimal cashAmount;  //提现金额
    private Byte applyStatus;
    private Date paidTime;
    private Long paidUserId;
    private String paidUserName;

    @Transient
    private String nickName;
    @Transient
    private String mobile;


}

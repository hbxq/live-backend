package com.xq.live.backend.persistence.beans;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "account_log")
public class AccountLog extends AbstractDO {

    public final static int OPERATE_TYPE_INCOME = 2;    //收入

    public final static int OPERATE_TYPE_PAYOUT = 1;    //支出

    private Long userId;
    private String userName;
    private Long accountId;
    private String accountName;
    private BigDecimal preAmount;
    private BigDecimal afterAmount;
    private BigDecimal operateAmount;
    private Integer operateType;
    private String remark;

}


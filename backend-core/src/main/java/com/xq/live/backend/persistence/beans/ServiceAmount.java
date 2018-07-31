package com.xq.live.backend.persistence.beans;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xq.live.backend.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ss on 2018/7/28.
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "service_amount")
public class ServiceAmount extends AbstractDO {

    private Long paidUserId;
    private Long shopId;
    private BigDecimal servicePrice;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date beginTime;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

}

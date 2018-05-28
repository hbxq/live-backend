package com.xq.live.backend.persistence.beans;

import com.xq.live.backend.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;
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
    private BigDecimal soAmount;
    private Long userId;
    private String userName;
    private Integer payType;
    private Integer soStatus;
    private Integer soType;
    private Date paidTime;
    private Date hxTime;

}

package com.xq.live.backend.business.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xq.live.backend.framework.object.BaseConditionVO;
import com.xq.live.backend.persistence.beans.So;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * com.xq.live.backend.business.vo
 *
 * @author zhangpeng32
 * Created on 2018/5/26 下午4:14
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SoConditionVO extends BaseConditionVO {
    private So so;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date beginTime;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date endTime;
}

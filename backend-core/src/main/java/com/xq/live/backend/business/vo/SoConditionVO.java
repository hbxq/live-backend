package com.xq.live.backend.business.vo;

import com.xq.live.backend.framework.object.BaseConditionVO;
import com.xq.live.backend.persistence.beans.So;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
}

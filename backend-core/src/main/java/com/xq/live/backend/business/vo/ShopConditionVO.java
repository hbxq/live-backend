package com.xq.live.backend.business.vo;

import com.xq.live.backend.business.entity.ShopBo;
import com.xq.live.backend.framework.object.BaseConditionVO;
import com.xq.live.backend.persistence.beans.Shop;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * com.xq.live.backend.business.vo
 *
 * @author zhangpeng32
 * Created on 2018/5/23 下午5:23
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ShopConditionVO extends BaseConditionVO {
    private ShopBo shopBo;
}

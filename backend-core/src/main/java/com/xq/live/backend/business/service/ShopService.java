package com.xq.live.backend.business.service;

import com.github.pagehelper.PageInfo;
import com.xq.live.backend.business.entity.ShopBo;
import com.xq.live.backend.business.vo.ShopConditionVO;
import com.xq.live.backend.framework.object.AbstractService;
import com.xq.live.backend.persistence.beans.Shop;

/**
 * com.xq.live.backend.business.service
 * 商家
 * @author zhangpeng32
 * Created on 2018/5/23 下午5:32
 * @Description:
 */
public interface ShopService extends AbstractService<ShopBo, Long> {
    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    PageInfo<ShopBo> findPageBreakByCondition(ShopConditionVO vo);


}

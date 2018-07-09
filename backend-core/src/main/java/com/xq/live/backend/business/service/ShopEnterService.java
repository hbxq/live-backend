package com.xq.live.backend.business.service;

import com.xq.live.backend.business.entity.ShopEnterBo;
import com.xq.live.backend.business.vo.ShopEnterVO;
import com.xq.live.backend.framework.object.AbstractService;
import com.xq.live.backend.persistence.beans.ShopEnter;

import java.util.List;

/**
 * Created by ss on 2018/7/4.
 */
public interface ShopEnterService extends AbstractService<ShopEnterBo, Long> {

    /**
     * 根据userId查询入驻信息,加入到商家表中
     * @param shopEnter
     * @return
     */
    Integer addShop(ShopEnterVO shopEnter);

    List<ShopEnter> selectByUserId(Long id);

    int updateById(ShopEnterVO record);

    
}

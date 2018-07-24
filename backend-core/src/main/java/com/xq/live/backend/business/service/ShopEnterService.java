package com.xq.live.backend.business.service;

import com.github.pagehelper.PageInfo;
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

    /**
     * 根据Id修改状态和备注
     * @param record
     * @return
     */
    int updateById(ShopEnterVO record);

    /**
     * 分页查询列表
     * @param record
     * @return
     */
    PageInfo<ShopEnterBo> selectBytemp(ShopEnterVO record);

    /**
     * 查询单条记录
     * @param record
     * @return
     */
    ShopEnterBo seedetail(ShopEnterVO record);

    
}

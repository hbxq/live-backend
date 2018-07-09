package com.xq.live.backend.persistence.mapper;

import com.xq.live.backend.business.vo.ShopEnterVO;
import com.xq.live.backend.persistence.beans.ShopEnter;
import com.xq.live.backend.plugin.BaseMapper;

import java.util.List;

/**
 * Created by ss on 2018/7/4.
 */
public interface ShopEnterMapper  extends BaseMapper<ShopEnter> {

    List<ShopEnter> selectByUserId(Long id);

    int updateById(ShopEnterVO record);

    ShopEnter selectById(Long id);

    List<ShopEnter> selectBytemp(ShopEnterVO record);
}

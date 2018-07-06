package com.xq.live.backend.persistence.mapper;

import com.xq.live.backend.business.vo.ShopCashierVO;
import com.xq.live.backend.persistence.beans.ShopCashier;
import com.xq.live.backend.plugin.BaseMapper;

/**
 * Created by ss on 2018/7/4.
 */
public interface ShopCashierMapper  extends BaseMapper<ShopCashier> {

    int insertCashier(ShopCashierVO record);


}

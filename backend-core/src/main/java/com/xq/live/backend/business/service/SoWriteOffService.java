package com.xq.live.backend.business.service;


import com.github.pagehelper.PageInfo;
import com.xq.live.backend.business.entity.WriteBo;
import com.xq.live.backend.business.vo.SoWriteOffInVo;
import com.xq.live.backend.framework.object.AbstractService;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author zhangpeng32
 * @date 2018-02-21 18:32
 * @copyright:hbxq
 **/
public interface SoWriteOffService extends AbstractService<WriteBo, Long> {
    /**
     * 分页查询商家核销票券
     * @param vo
     * @return
     */
    PageInfo<WriteBo> findSoForShop(SoWriteOffInVo vo);

    /**
     * 不分页查询商家核销票券
     * @param vo
     * @return
     */
    WriteBo findSoShop(SoWriteOffInVo vo);

    /**
     * 不根据shopid和时间批量更改商家訂單
     * @param vo
     * @return
     */
    Integer updateByShopId(SoWriteOffInVo vo);
}

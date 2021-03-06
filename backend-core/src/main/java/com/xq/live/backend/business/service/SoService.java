package com.xq.live.backend.business.service;

import com.github.pagehelper.PageInfo;
import com.xq.live.backend.business.entity.SoBo;
import com.xq.live.backend.business.vo.SoConditionVO;
import com.xq.live.backend.framework.object.AbstractService;

import java.util.List;

/**
 * Created by lipeng on 2018/6/26.
 */
public interface SoService extends AbstractService<SoBo, Long> {
    /**
     * 分页查询
     * @param vo
     * @return
     */
    PageInfo<SoBo> findPageBreakByCondition(SoConditionVO vo);

    /**
     * 分页查询食典券
     * @param vo
     * @return
     */
    PageInfo<SoBo> findSoForShop(SoConditionVO vo);

    /**
     * 分页查询商家訂單
     * @param vo
     * @return
     */
    PageInfo<SoBo> findSoForShops(SoConditionVO vo);

    /**
     * 不分页查询商家訂單
     * @param vo
     * @return
     */
    SoBo findSoShop(SoConditionVO vo);

    /**
     * 根据soid批量更改商家訂單(不可用)
     * @param list
     * @return
     */
    Integer updateBySO( List<SoConditionVO> list);

    /**
     * 根据shopid和时间批量更改食典券
     * @param list
     * @return
     */
    Integer updateByShopId(SoConditionVO list);

    /**
     * 查看订单明细
     * @param vo
     * @return
     */
    SoBo detail(SoConditionVO vo);

    /**
     * 修改用户余额
     * @param list
     * @return
     */
    Integer updateUseract(SoConditionVO list);

}

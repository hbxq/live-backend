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
     * 分页查询商家訂單
     * @param vo
     * @return
     */
    PageInfo<SoBo> findSoForShop(SoConditionVO vo);

    /**
     * 批量更改商家訂單
     * @param list
     * @return
     */
    Integer updateBySO( List<SoConditionVO> list);
}

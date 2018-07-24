package com.xq.live.backend.business.service;

import com.github.pagehelper.PageInfo;
import com.xq.live.backend.business.entity.CashApplyBo;
import com.xq.live.backend.business.vo.CashApplyConditionVO;
import com.xq.live.backend.framework.object.AbstractService;

/**
 * Created by ss on 2018/7/19.
 */
public interface CashApplyService extends AbstractService<CashApplyBo, Long> {

    /**
     * 分页查询列表
     * @param invo
     * @return
     */
    PageInfo<CashApplyBo> selectBykeywords(CashApplyConditionVO invo);
}

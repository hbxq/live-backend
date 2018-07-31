package com.xq.live.backend.persistence.mapper;

import com.xq.live.backend.business.vo.CashApplyConditionVO;
import com.xq.live.backend.persistence.beans.CashApply;
import com.xq.live.backend.plugin.BaseMapper;

import java.util.List;

/**
 * Created by ss on 2018/7/19.
 */
public interface CashApplyMapper extends BaseMapper<CashApply> {

    /**
     * 按条件模糊查询一段时间内的申请
     * @param invo
     * @return
     */
     List<CashApply> selectCashlist(CashApplyConditionVO invo);

    /**
     * 修改申请状态
     * @param inVo
     * @return
     */
    Integer paystart(CashApplyConditionVO inVo);


}

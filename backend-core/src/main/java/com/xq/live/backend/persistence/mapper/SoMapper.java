package com.xq.live.backend.persistence.mapper;

import com.github.pagehelper.PageInfo;
import com.xq.live.backend.business.entity.SoBo;
import com.xq.live.backend.business.vo.SoConditionVO;
import com.xq.live.backend.persistence.beans.So;
import com.xq.live.backend.plugin.BaseMapper;

import java.util.List;

/**
 * com.xq.live.backend.persistence.mapper
 *
 * @author zhangpeng32
 * Created on 2018/5/26 下午4:13
 * @Description:
 */
public interface SoMapper extends BaseMapper<So> {
    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    List<So> findPageBreakByCondition(SoConditionVO vo);

    /**
     * 分页查询商家訂單
     * @param vo
     * @return
     */
    List<So> findSoForShop(SoConditionVO vo);

    /**
     * 批量更改商家訂單
     * @param list
     * @return
     */
    Integer updateBySO( List<SoConditionVO> list);
}

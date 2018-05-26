package com.xq.live.backend.persistence.mapper;

import com.xq.live.backend.business.vo.ShopConditionVO;
import com.xq.live.backend.persistence.beans.Shop;
import com.xq.live.backend.persistence.beans.SysResources;
import com.xq.live.backend.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * com.xq.live.backend.persistence.mapper
 *
 * @author zhangpeng32
 * Created on 2018/5/23 下午5:30
 * @Description:
 */
@Repository
public interface ShopMapper extends BaseMapper<Shop> {
    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    List<Shop> findPageBreakByCondition(ShopConditionVO vo);
}

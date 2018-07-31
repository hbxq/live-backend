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
     * 分页查询商家訂單
     * @param vo
     * @return
     */
    List<So> findSoForShops(SoConditionVO vo);


    /**
     * 根据soid批量更改商家訂單
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
     * 根据shopid和时间批量更改已核销的平台订单(食典券)
     * @param list
     * @return
     */
    Integer updateByShopIdBill(SoConditionVO list);

    /**
     * 根据shopid和时间查询平台订单(食典券)
     * @param list
     * @return
     */
    List<So> findSoForIsDui(SoConditionVO list);

    /**
     * 根据shopid和时间查询平台订单(商家订单)
     * @param list
     * @return
     */
    List<So> findShopForIsDui(SoConditionVO list);


    /**
     * 根据shopid和时间批量更改商家订单
     * @param list
     * @return
     */
    Integer updateByShopIds(SoConditionVO list);

}

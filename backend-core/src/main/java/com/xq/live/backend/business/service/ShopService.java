package com.xq.live.backend.business.service;

import com.github.pagehelper.PageInfo;
import com.xq.live.backend.business.vo.ShopConditionVO;
import com.xq.live.backend.framework.object.AbstractService;
import com.xq.live.backend.persistence.beans.Shop;

import java.util.List;

/**
 * com.xq.live.backend.business.service
 * 商家
 * @author zhangpeng32
 * Created on 2018/5/23 下午5:32
 * @Description:
 */
public interface ShopService extends AbstractService<Shop, Long> {
    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    PageInfo<Shop> findPageBreakByCondition(ShopConditionVO vo);

    /**
     * 根据商家名查询
     *
     * @param shopName
     * @return
     */
    Shop findBreakByName(String shopName);

    /**
     * 根据商家名模糊查询
     *
     * @param shopName
     * @return
     */
    List<Shop> findfuzzyByName(String shopName);

    /**
     * 根据UserID查询
     *
     * @param id
     * @return
     */
    Shop findBreakByUserId(Long id);

    /**
     * 根据商家ID查询
     *
     * @param id
     * @return
     */
    Shop findBreakByShopId(Long id);

    /**
     * 添加商家信息
     *
     * @param vo
     * @return
     */
    int insertShopInfo(Shop vo);

    /**
     * 修改商家信息-
     *
     * @param vo
     * @return
     */
    int changeShopInfo(Shop vo);

    /**
     * 批量删除商家信息
     *
     * @param id
     * @return
     */
    int deleteShopByID(List<Shop> id);
}

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

    /**
     * 根据商家名查询
     *
     * @param shopName
     * @return
     */
    Shop selectByShopName(String shopName);

    /**
     * 根据商家名模糊查询
     *
     * @param shopName
     * @return
     */
    List<Shop> fuzzyByShopName(String shopName);


    /**
     * 根据UserID查询
     *
     * @param id
     * @return
     */
    Shop getShopByUserId(Long id);

    /**
     * 根据ShopID查询
     *
     * @param id
     * @return
     */
    Shop getShopByShopId(Long id);


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
    int updateshop(Shop vo);

    /**
     * 批量删除商家信息
     *
     * @param id
     * @return
     */
    int deleteshop(List<Shop> id);


    int insertShop(Shop record);

}

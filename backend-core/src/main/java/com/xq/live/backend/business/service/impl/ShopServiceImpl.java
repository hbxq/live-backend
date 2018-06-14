package com.xq.live.backend.business.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xq.live.backend.business.service.ShopService;
import com.xq.live.backend.business.vo.ShopConditionVO;
import com.xq.live.backend.persistence.beans.Shop;
import com.xq.live.backend.persistence.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * com.xq.live.backend.business.service.impl
 *
 * @author zhangpeng32
 * Created on 2018/5/23 下午5:33
 * @Description:
 */
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopMapper shopMapper;

    @Override
    public PageInfo<Shop> findPageBreakByCondition(ShopConditionVO vo) {
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        List<Shop> shops = shopMapper.findPageBreakByCondition(vo);
        if (CollectionUtils.isEmpty(shops)) {
            return null;
        }
        PageInfo bean = new PageInfo<Shop>(shops);
        bean.setList(shops);
        return bean;
    }

    @Override
    public Shop findBreakByName(String shopName) {
        Shop shop=shopMapper.selectByShopName(shopName);
        if (shop==null){
            return null;
        }
        return shop;
    }

    @Override
    public List<Shop> findfuzzyByName(String shopName) {
        List<Shop> shop=shopMapper.fuzzyByShopName(shopName);
        if (shop==null){
            return null;
        }
        return shop;
    }

    @Override
    public Shop findBreakByUserId(Long id) {
        Shop shop=shopMapper.getShopByUserId(id);
        if (shop == null){
            return null;
        }
        return shop;
    }

    @Override
    public Shop findBreakByShopId(Long id) {
        Shop shop=shopMapper.getShopByShopId(id);
        if (shop == null){
            return null;
        }
        return shop;
    }

    @Override
    public int insertShopInfo(Shop vo) {
        int i=shopMapper.insertShopInfo(vo);
        if (i>0){
            return 1;
        }
        return 0;
    }

    @Override
    public int changeShopInfo(Shop vo) {
        int i=shopMapper.updateshop(vo);
        if (i>0){
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteShopByID(List<Shop> id) {
        int i=shopMapper.deleteshop(id);
        if (i>0){
            return 1;
        }
        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Shop insert(Shop shop) {
        Assert.notNull(shop, "Shop不可为空！");
        shop.setUpdateTime(new Date());
        shop.setCreateTime(new Date());
        shop.setShopStatus(1);
        shopMapper.insertSelective(shop);
        return shop;
    }

    @Override
    public void insertList(List<Shop> shops) {
        Assert.notNull(shops, "Shops不可为空！");
        for (Shop shop : shops) {
            shop.setUpdateTime(new Date());
            shop.setCreateTime(new Date());
            shop.setShopStatus(1);
        }
        shopMapper.insertList(shops);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeByPrimaryKey(Long primaryKey) {
        return shopMapper.deleteByPrimaryKey(primaryKey) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(Shop shop) {
        Assert.notNull(shop, "Shop不可为空！");
        shop.setUpdateTime(new Date());
        return shopMapper.updateByPrimaryKey(shop) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateSelective(Shop shop) {
        Assert.notNull(shop, "shop不可为空！");
        shop.setUpdateTime(new Date());
        return shopMapper.updateByPrimaryKeySelective(shop) > 0;
    }

    @Override
    public Shop getByPrimaryKey(Long primaryKey) {
        Assert.notNull(primaryKey, "PrimaryKey不可为空！");
        Shop shop = shopMapper.selectByPrimaryKey(primaryKey);
        return shop;
    }

    @Override
    public Shop getOneByEntity(Shop entity) {
        Assert.notNull(entity, "Shop不可为空！");
        return shopMapper.selectOne(entity);
    }

    @Override
    public List<Shop> listAll() {
        return shopMapper.selectAll();
    }

    @Override
    public List<Shop> listByEntity(Shop shop) {
        Assert.notNull(shop, "Shop不可为空！");
        List<Shop> shops = shopMapper.select(shop);
        if (CollectionUtils.isEmpty(shops)) {
            return null;
        }
        return shops;
    }
}

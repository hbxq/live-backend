package com.xq.live.backend.business.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xq.live.backend.business.entity.ShopBo;
import com.xq.live.backend.business.enums.ShopStatusEnum;
import com.xq.live.backend.business.service.ShopService;
import com.xq.live.backend.business.vo.ShopConditionVO;
import com.xq.live.backend.persistence.beans.Shop;
import com.xq.live.backend.persistence.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
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
    public PageInfo<ShopBo> findPageBreakByCondition(ShopConditionVO vo) {
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        List<Shop> shops = shopMapper.findPageBreakByCondition(vo);
        if (CollectionUtils.isEmpty(shops)) {
            return null;
        }
        List<ShopBo> shopBos = new ArrayList<>();
        for (Shop r : shops) {
            shopBos.add(new ShopBo(r));
        }
        PageInfo bean = new PageInfo<ShopBo>(shopBos);
        bean.setList(shopBos);
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
    public ShopBo insert(ShopBo entity) {
        Assert.notNull(entity, "Shop不可为空！");
        entity.setUpdateTime(new Date());
        entity.setCreateTime(new Date());
        entity.setShopStatus(ShopStatusEnum.NORMAL.getCode());
        shopMapper.insertSelective(entity.getShop());
        return entity;
    }

    @Override
    public void insertList(List<ShopBo> shopBos) {
        Assert.notNull(shopBos, "Shops不可为空！");
        List<Shop> shops = new ArrayList<>();
        for (ShopBo shopBo : shopBos) {
            shopBo.setUpdateTime(new Date());
            shopBo.setCreateTime(new Date());
            shopBo.setShopStatus(ShopStatusEnum.NORMAL.getCode());
            shops.add(shopBo.getShop());
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
    public boolean update(ShopBo shopBo) {
        Assert.notNull(shopBo, "Shop不可为空！");
        shopBo.setUpdateTime(new Date());
        return shopMapper.updateByPrimaryKey(shopBo.getShop()) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateSelective(ShopBo shopBo) {
        Assert.notNull(shopBo, "shop不可为空！");
        shopBo.setUpdateTime(new Date());
        return shopMapper.updateByPrimaryKeySelective(shopBo.getShop()) > 0;
    }

    @Override
    public ShopBo getByPrimaryKey(Long primaryKey) {
        Assert.notNull(primaryKey, "PrimaryKey不可为空！");
        Shop shop = shopMapper.selectByPrimaryKey(primaryKey);
        return null == shop ? null : new ShopBo(shop);
    }

    @Override
    public ShopBo getOneByEntity(ShopBo entity) {
        Assert.notNull(entity, "Shop不可为空！");
        Shop shop = shopMapper.selectOne(entity.getShop());
        return null == shop ? null : new ShopBo(shop);
    }

    @Override
    public List<ShopBo> listAll() {
        List<Shop> shops = shopMapper.selectAll();

        if (CollectionUtils.isEmpty(shops)) {
            return null;
        }
        List<ShopBo> shopBos = new ArrayList<>();
        for (Shop shop : shops) {
            shopBos.add(new ShopBo(shop));
        }
        return shopBos;
    }

    @Override
    public List<ShopBo> listByEntity(ShopBo shopBo) {
        Assert.notNull(shopBo, "Shop不可为空！");
        List<Shop> shops = shopMapper.select(shopBo.getShop());
        if (CollectionUtils.isEmpty(shops)) {
            return null;
        }
        List<ShopBo> shopBos = new ArrayList<>();
        for (Shop su : shops) {
            shopBos.add(new ShopBo(su));
        }
        return shopBos;
    }
}

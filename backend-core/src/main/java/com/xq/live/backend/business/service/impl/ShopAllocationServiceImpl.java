package com.xq.live.backend.business.service.impl;

import com.xq.live.backend.business.entity.ShopAllocationBo;
import com.xq.live.backend.business.service.ShopAllocationService;
import com.xq.live.backend.persistence.beans.ShopAllocation;

import java.util.List;

/**
 *
 * 商家收款方式配置表
 * Created by ss on 2018/7/4.
 */
public class ShopAllocationServiceImpl implements ShopAllocationService{

    @Override
    public ShopAllocationBo insert(ShopAllocationBo entity) {
        return null;
    }

    @Override
    public void insertList(List<ShopAllocationBo> entities) {

    }

    @Override
    public boolean removeByPrimaryKey(Long primaryKey) {
        return false;
    }

    @Override
    public boolean update(ShopAllocationBo entity) {
        return false;
    }

    @Override
    public boolean updateSelective(ShopAllocationBo entity) {
        return false;
    }

    @Override
    public ShopAllocationBo getByPrimaryKey(Long primaryKey) {
        return null;
    }

    @Override
    public ShopAllocationBo getOneByEntity(ShopAllocationBo entity) {
        return null;
    }

    @Override
    public List<ShopAllocationBo> listAll() {
        return null;
    }

    @Override
    public List<ShopAllocationBo> listByEntity(ShopAllocationBo entity) {
        return null;
    }
}

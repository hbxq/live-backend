package com.xq.live.backend.business.service.impl;

import com.xq.live.backend.business.entity.UserBo;
import com.xq.live.backend.business.service.UserService;

import java.util.List;

/**
 * Created by ss on 2018/7/5.
 */
public class UserServiceImpl implements UserService{




    @Override
    public UserBo insert(UserBo entity) {
        return null;
    }

    @Override
    public void insertList(List<UserBo> entities) {

    }

    @Override
    public boolean removeByPrimaryKey(Long primaryKey) {
        return false;
    }

    @Override
    public boolean update(UserBo entity) {
        return false;
    }

    @Override
    public boolean updateSelective(UserBo entity) {
        return false;
    }

    @Override
    public UserBo getByPrimaryKey(Long primaryKey) {
        return null;
    }

    @Override
    public UserBo getOneByEntity(UserBo entity) {
        return null;
    }

    @Override
    public List<UserBo> listAll() {
        return null;
    }

    @Override
    public List<UserBo> listByEntity(UserBo entity) {
        return null;
    }
}

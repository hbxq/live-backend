package com.xq.live.backend.business.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xq.live.backend.business.entity.ServiceAmountBo;
import com.xq.live.backend.business.service.ServiceAmountService;
import com.xq.live.backend.business.vo.ServiceAmountVO;
import com.xq.live.backend.persistence.beans.ServiceAmount;
import com.xq.live.backend.persistence.mapper.ServiceAmountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ss on 2018/7/28.
 */
@Service
public class ServiceAmountServiceImpl implements ServiceAmountService{

    @Autowired
    private ServiceAmountMapper serviceAmountMapper;



    @Override
    public ServiceAmount insert(ServiceAmount entity) {
        return null;
    }

    @Override
    public void insertList(List<ServiceAmount> entities) {

    }

    @Override
    public boolean removeByPrimaryKey(Long primaryKey) {
        return false;
    }

    @Override
    public boolean update(ServiceAmount entity) {
        return false;
    }

    @Override
    public boolean updateSelective(ServiceAmount entity) {
        return false;
    }

    @Override
    public ServiceAmount getByPrimaryKey(Long primaryKey) {
        return null;
    }

    @Override
    public ServiceAmount getOneByEntity(ServiceAmount entity) {
        return null;
    }

    @Override
    public List<ServiceAmount> listAll() {
        return null;
    }

    @Override
    public List<ServiceAmount> listByEntity(ServiceAmount entity) {
        return null;
    }

    @Override
    public PageInfo<ServiceAmountBo> findShopService(ServiceAmountVO vo) {
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        List<ServiceAmount> amounts = serviceAmountMapper.findShopService(vo);
        if (CollectionUtils.isEmpty(amounts)) {
            return null;
        }
        List<ServiceAmountBo> SerAmountBo = new ArrayList<>();

        for (ServiceAmount swo:amounts){

            SerAmountBo.add(new ServiceAmountBo(swo));
        }
        PageInfo bean = new PageInfo<ServiceAmount>(amounts);
        bean.setList(SerAmountBo);
        return bean;
    }
}

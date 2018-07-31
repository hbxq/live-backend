package com.xq.live.backend.business.service;

import com.github.pagehelper.PageInfo;
import com.xq.live.backend.business.entity.ServiceAmountBo;
import com.xq.live.backend.business.vo.ServiceAmountVO;
import com.xq.live.backend.framework.object.AbstractService;
import com.xq.live.backend.persistence.beans.ServiceAmount;

/**
 * Created by ss on 2018/7/28.
 */
public interface ServiceAmountService extends AbstractService<ServiceAmount, Long> {


    /**
     * 分页查询
     * @param vo
     * @return
     */
    PageInfo<ServiceAmountBo> findShopService(ServiceAmountVO vo);

}

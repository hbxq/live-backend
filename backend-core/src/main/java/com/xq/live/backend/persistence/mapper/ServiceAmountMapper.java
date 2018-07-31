package com.xq.live.backend.persistence.mapper;

import com.xq.live.backend.business.vo.ServiceAmountVO;
import com.xq.live.backend.persistence.beans.ServiceAmount;
import com.xq.live.backend.plugin.BaseMapper;

import java.util.List;

/**
 * Created by ss on 2018/7/28.
 */
public interface ServiceAmountMapper  extends BaseMapper<ServiceAmount> {

    /*查询商家一段时间内的服务费信息*/
    List<ServiceAmount> findShopService(ServiceAmountVO vo);

}

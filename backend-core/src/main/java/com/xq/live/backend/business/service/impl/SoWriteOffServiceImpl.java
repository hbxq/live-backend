package com.xq.live.backend.business.service.impl;

import com.github.pagehelper.PageInfo;
import com.xq.live.backend.business.out.SoWriteOffOut;
import com.xq.live.backend.business.service.SoWriteOffService;
import com.xq.live.backend.business.vo.SoWriteOffInVo;
import com.xq.live.backend.persistence.beans.SoWriteOff;
import com.xq.live.backend.persistence.mapper.SoWriteOffMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * ${DESCRIPTION}
 *
 * @author zhangpeng32
 * @date 2018-02-21 18:37
 * @copyright:hbxq
 **/
@Service
public class SoWriteOffServiceImpl implements SoWriteOffService {

    private Logger logger = Logger.getLogger(SoWriteOffServiceImpl.class);

    @Autowired
    private SoWriteOffMapper soWriteOffMapper;

    @Override
    public PageInfo<SoWriteOffOut> list(SoWriteOffInVo inVo) {
        PageInfo<SoWriteOffOut> ret = new PageInfo<SoWriteOffOut>();
        int total = soWriteOffMapper.listTotal(inVo);
        List<SoWriteOffOut> totalOut = soWriteOffMapper.total(inVo);
        if(total > 0){
            List<SoWriteOffOut> list = soWriteOffMapper.list(inVo);
            list.addAll(0,totalOut);//把总销售额和总服务费放到list的第一个数据里面
            ret.setList(list);
        }
        ret.setTotal(total);
        ret.setEndRow(inVo.getRows());
        ret.setPageNum(inVo.getPage());
        return ret;
    }

    //根据shopId查询指定时间内的总金额的应缴金额
    @Override
    public List<SoWriteOffOut> listAmount(SoWriteOffInVo inVo) {
        List<SoWriteOffOut> list=soWriteOffMapper.total(inVo);
        if (list==null||list.size()<=0){
            return null;
        }
        return list;
    }

    @Override
    public List<SoWriteOffOut> top(SoWriteOffInVo inVo) {
        return soWriteOffMapper.list(inVo);
    }

    @Override
    public SoWriteOff get(Long id) {
        return soWriteOffMapper.selectByPrimaryKey(id);
    }

    @Override
    public int listTotal(SoWriteOffInVo inVo) {
        return soWriteOffMapper.listTotal(inVo);
    }

    @Override
    public Integer shopSoByBill(List<SoWriteOffInVo> inVo) {
        Integer i=soWriteOffMapper.shopSoByBill(inVo);
        if (i>0){
            return 1;
        }
        return null;
    }
}

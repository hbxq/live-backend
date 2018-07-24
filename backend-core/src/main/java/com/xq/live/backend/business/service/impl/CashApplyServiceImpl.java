package com.xq.live.backend.business.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xq.live.backend.business.entity.CashApplyBo;
import com.xq.live.backend.business.service.CashApplyService;
import com.xq.live.backend.business.vo.CashApplyConditionVO;
import com.xq.live.backend.persistence.beans.CashApply;
import com.xq.live.backend.persistence.mapper.CashApplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ss on 2018/7/19.
 */
@Service
public class CashApplyServiceImpl implements CashApplyService{

    @Autowired
    private CashApplyMapper cashApplyMapper;

    @Override
    public CashApplyBo insert(CashApplyBo entity) {
        return null;
    }

    @Override
    public void insertList(List<CashApplyBo> entities) {

    }

    @Override
    public boolean removeByPrimaryKey(Long primaryKey) {
        return false;
    }

    @Override
    public boolean update(CashApplyBo entity) {
        return false;
    }

    @Override
    public boolean updateSelective(CashApplyBo entity) {
        return false;
    }

    @Override
    public CashApplyBo getByPrimaryKey(Long primaryKey) {
        return null;
    }

    @Override
    public CashApplyBo getOneByEntity(CashApplyBo entity) {
        return null;
    }

    @Override
    public List<CashApplyBo> listAll() {
        return null;
    }

    @Override
    public List<CashApplyBo> listByEntity(CashApplyBo entity) {
        return null;
    }

    @Override
    public PageInfo<CashApplyBo> selectBykeywords(CashApplyConditionVO invo) {
        PageHelper.startPage(invo.getPageNumber(), invo.getPageSize());
        List<CashApply> list=cashApplyMapper.selectCashlist(invo);
        if (list.size()<1||list==null){
            return null;
        }
        List<CashApplyBo> ActTopicBos=new ArrayList<CashApplyBo>();
        for (CashApply r : list) {
            ActTopicBos.add(new CashApplyBo(r));
        }
        PageInfo bean = new PageInfo<CashApply>(list);
        bean.setList(ActTopicBos);
        return bean;
    }
}

package com.xq.live.backend.business.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xq.live.backend.business.entity.ActTopicBo;
import com.xq.live.backend.business.service.ActTopicService;
import com.xq.live.backend.business.vo.ActTopicConditionVO;
import com.xq.live.backend.persistence.beans.ActTopic;
import com.xq.live.backend.persistence.mapper.ActTopicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ss on 2018/7/17.
 */
@Service
public class ActTopicServiceImpl implements ActTopicService{

    @Autowired
    private ActTopicMapper actTopicMapper;

    @Override
    public ActTopicBo insert(ActTopicBo entity) {
        return null;
    }

    @Override
    public void insertList(List<ActTopicBo> entities) {

    }

    @Override
    public boolean removeByPrimaryKey(Long primaryKey) {
        return false;
    }

    @Override
    public boolean update(ActTopicBo entity) {
        return false;
    }

    @Override
    public boolean updateSelective(ActTopicBo entity) {
        return false;
    }

    @Override
    public ActTopicBo getByPrimaryKey(Long primaryKey) {
        return null;
    }

    @Override
    public ActTopicBo getOneByEntity(ActTopicBo entity) {
        return null;
    }

    @Override
    public List<ActTopicBo> listAll() {
        return null;
    }

    @Override
    public List<ActTopicBo> listByEntity(ActTopicBo entity) {
        return null;
    }

    @Override
    public PageInfo<ActTopicBo> selectBykeywords(ActTopicConditionVO invo) {
        PageHelper.startPage(invo.getPageNumber(), invo.getPageSize());
        List<ActTopic> list=actTopicMapper.selectBykeywords(invo);
        if (list.size()<1||list==null){
            return null;
        }
        List<ActTopicBo> ActTopicBos=new ArrayList<ActTopicBo>();
        for (ActTopic r : list) {
            ActTopicBos.add(new ActTopicBo(r));
        }
        PageInfo bean = new PageInfo<ActTopic>(list);
        bean.setList(ActTopicBos);
        return bean;
    }

    @Override
    public int updateById(ActTopicConditionVO invo) {
        Integer i=actTopicMapper.updateById(invo);
        if (i==null||i<0){
            return 0;
        }
        return i;
    }

    @Override
    public ActTopicBo seedetail(ActTopicConditionVO invo) {
        List<ActTopic> list=actTopicMapper.selectBykeywords(invo);
        if (list.size()<1||list==null){
            return null;
        }
        ActTopicBo ActTopicBo = new ActTopicBo(list.get(0));
        return ActTopicBo;
    }
}

package com.xq.live.backend.business.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xq.live.backend.business.entity.TopicBo;
import com.xq.live.backend.business.service.TopicService;
import com.xq.live.backend.business.vo.TopicConditionVO;
import com.xq.live.backend.persistence.beans.Topic;
import com.xq.live.backend.persistence.mapper.TopicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ss on 2018/7/15.
 */
@Service
public class TopicServiceImpl implements TopicService{

    @Autowired
    private TopicMapper topicMapper;

    @Override
    public TopicBo insert(TopicBo entity) {
        return null;
    }

    @Override
    public void insertList(List<TopicBo> entities) {

    }

    @Override
    public boolean removeByPrimaryKey(Long primaryKey) {
        return false;
    }

    @Override
    public boolean update(TopicBo entity) {
        return false;
    }

    @Override
    public boolean updateSelective(TopicBo entity) {
        return false;
    }

    @Override
    public TopicBo getByPrimaryKey(Long primaryKey) {
        return null;
    }

    @Override
    public TopicBo getOneByEntity(TopicBo entity) {
        return null;
    }

    @Override
    public List<TopicBo> listAll() {
        return null;
    }

    @Override
    public List<TopicBo> listByEntity(TopicBo entity) {
        return null;
    }

    @Override
    public PageInfo<TopicBo> selectBytemp(TopicConditionVO invo) {
        PageHelper.startPage(invo.getPageNumber(), invo.getPageSize());
        List<Topic> list=topicMapper.topiclist(invo);
        if (list.size()<1||list==null){
            return null;
        }
        List<TopicBo> TopicBos=new ArrayList<TopicBo>();
        for (Topic r : list) {
            TopicBos.add(new TopicBo(r));
        }
        PageInfo bean = new PageInfo<Topic>(list);
        bean.setList(TopicBos);
        return bean;
    }

    @Override
    public int updateById(TopicConditionVO invo) {
        Integer i=topicMapper.updateById(invo);
        if (i==null||i<0){
            return 0;
        }
        return i;
    }

    @Override
    public TopicBo seedetail(TopicConditionVO invo) {
        List<Topic> list=topicMapper.topiclist(invo);
        if (list.size()<1||list==null){
            return null;
        }
        TopicBo TopicBo = new TopicBo(list.get(0));
        return TopicBo;
    }
}

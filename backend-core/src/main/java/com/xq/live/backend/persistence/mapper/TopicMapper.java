package com.xq.live.backend.persistence.mapper;

import com.xq.live.backend.business.vo.TopicConditionVO;
import com.xq.live.backend.persistence.beans.Topic;
import com.xq.live.backend.plugin.BaseMapper;

import java.util.List;

/**
 * Created by ss on 2018/7/14.
 */
public interface TopicMapper extends BaseMapper<Topic> {

    /*
    * 按条件模糊查询一段时间内的视频文章
    * */
    List<Topic> topiclist(TopicConditionVO invo);

    /*
    * 根据id修改视频文章状态
    * */
    int updateById(TopicConditionVO invo);


}

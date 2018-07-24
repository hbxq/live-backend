package com.xq.live.backend.persistence.mapper;

import com.xq.live.backend.business.vo.ActTopicConditionVO;
import com.xq.live.backend.persistence.beans.ActTopic;
import com.xq.live.backend.plugin.BaseMapper;

import java.util.List;

/**
 * Created by ss on 2018/7/17.
 */
public interface ActTopicMapper  extends BaseMapper<ActTopic> {

    /*
   * 按条件模糊查询一段时间内的视频文章
   * */
    List<ActTopic> selectBykeywords(ActTopicConditionVO invo);

    /*
    * 根据id修改视频文章状态
    * */
    int updateById(ActTopicConditionVO invo);
}

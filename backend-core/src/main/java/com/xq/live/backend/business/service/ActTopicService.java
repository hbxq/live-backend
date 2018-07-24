package com.xq.live.backend.business.service;

import com.github.pagehelper.PageInfo;
import com.xq.live.backend.business.entity.ActTopicBo;
import com.xq.live.backend.business.vo.ActTopicConditionVO;
import com.xq.live.backend.framework.object.AbstractService;
import com.xq.live.backend.persistence.beans.ActTopic;

import java.util.List;

/**
 * Created by ss on 2018/7/17.
 */
public interface ActTopicService extends AbstractService<ActTopicBo, Long> {

    /**
     * 分页查询列表
     * @param invo
     * @return
     */
    PageInfo<ActTopicBo> selectBykeywords(ActTopicConditionVO invo);

    /*
    * 根据id修改视频文章状态
    * */
    int updateById(ActTopicConditionVO invo);

    /**
     * 查询单条记录
     * @param invo
     * @return
     */
    ActTopicBo seedetail(ActTopicConditionVO invo);
}

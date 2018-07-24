package com.xq.live.backend.business.service;

import com.github.pagehelper.PageInfo;
import com.xq.live.backend.business.entity.TopicBo;
import com.xq.live.backend.business.vo.TopicConditionVO;
import com.xq.live.backend.framework.object.AbstractService;

/**
 * Created by ss on 2018/7/15.
 */
public interface TopicService extends AbstractService<TopicBo, Long> {
    /**
     * 分页查询列表
     * @param invo
     * @return
     */
    PageInfo<TopicBo> selectBytemp(TopicConditionVO invo);

    /**
     * 根据Id修改状态和备注
     * @param invo
     * @return
     */
    int updateById(TopicConditionVO invo);

    /**
     * 查询单条记录
     * @param invo
     * @return
     */
    TopicBo seedetail(TopicConditionVO invo);
}

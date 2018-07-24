package com.xq.live.backend.controller;

import com.github.pagehelper.PageInfo;
import com.xq.live.backend.business.entity.TopicBo;
import com.xq.live.backend.business.service.ActTopicService;
import com.xq.live.backend.business.service.TopicService;
import com.xq.live.backend.business.vo.ActTopicConditionVO;
import com.xq.live.backend.business.vo.TopicConditionVO;
import com.xq.live.backend.framework.object.PageResult;
import com.xq.live.backend.framework.object.ResponseVO;
import com.xq.live.backend.persistence.beans.ActTopic;
import com.xq.live.backend.persistence.beans.Topic;
import com.xq.live.backend.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ss on 2018/7/16.
 */
@RestController
@RequestMapping("/topic")
public class RestTopicController {

    @Autowired
    private TopicService topicService;

    @Autowired
    private ActTopicService actTopicService;


    /**
     * 加载初始化表数据和查询列表
     *
     * @param invo
     * @return
     */
    @PostMapping(value = "/seelist")
    public PageResult topiclist(TopicConditionVO invo) {
        PageInfo<TopicBo> pageInfo = topicService.selectBytemp(invo);
        return ResultUtil.tablePage(pageInfo);
    }

    /**
     * 视频驳回
     * @param topic
     * @return
     */
    @PostMapping(value = "/outreject")
    public ResponseVO outreject(TopicConditionVO topic) {
        ActTopicConditionVO acttopic = new ActTopicConditionVO();
        acttopic.setTopicId(topic.getId());
        acttopic.setApplyStatus(ActTopic.ACTTOPIC_STATUS_OUT);
        Integer in = actTopicService.updateById(acttopic);
        if(in==0){
            return  ResultUtil.error("修改失败");
        }
        topic.setTpStatus(Topic.TOPIC_STATUS_OUT);
        Integer integer = topicService.updateById(topic);
        if(integer==0){
            return  ResultUtil.error("修改失败");
        }
        return ResultUtil.success("视频未通过审核");
    }

    /**
     * 视频通过
     * @param topic
     * @return
     */
    @PostMapping(value = "/inreject")
    public ResponseVO inreject(TopicConditionVO topic) {
        ActTopicConditionVO acttopic = new ActTopicConditionVO();
        acttopic.setTopicId(topic.getId());
        acttopic.setApplyStatus(ActTopic.ACTTOPIC_STATUS_IN);
        Integer in = actTopicService.updateById(acttopic);
        if(in==0){
            return  ResultUtil.error("修改失败");
        }
        topic.setTpStatus(Topic.TOPIC_STATUS_IN);
        Integer integer = topicService.updateById(topic);
        if(integer==0){
            return  ResultUtil.error("修改失败");
        }
        return ResultUtil.success("视频通过审核");
    }

    /**
     * 查看明细
     *
     * @param
     * @return
     */
    @PostMapping(value = "/detail")
    public ResponseVO seedetail(TopicConditionVO topic) {
        TopicBo topicBo = topicService.seedetail(topic);
        return ResultUtil.success("1", topicBo);
    }
}

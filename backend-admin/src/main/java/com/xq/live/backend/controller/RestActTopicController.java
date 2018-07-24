package com.xq.live.backend.controller;

import com.github.pagehelper.PageInfo;
import com.xq.live.backend.business.entity.ActTopicBo;
import com.xq.live.backend.business.service.ActTopicService;
import com.xq.live.backend.business.vo.ActTopicConditionVO;
import com.xq.live.backend.framework.object.PageResult;
import com.xq.live.backend.framework.object.ResponseVO;
import com.xq.live.backend.persistence.beans.ActTopic;
import com.xq.live.backend.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ss on 2018/7/17.
 */
@RestController
@RequestMapping("/acttopic")
public class RestActTopicController {

    @Autowired
    private ActTopicService actTopicService;



    /**
     * 加载初始化表数据和查询列表
     *
     * @param invo
     * @return
     */
    @PostMapping(value = "/seelist")
    public PageResult topiclist(ActTopicConditionVO invo) {
        PageInfo<ActTopicBo> pageInfo = actTopicService.selectBykeywords(invo);
        return ResultUtil.tablePage(pageInfo);
    }

    /**
     * 视频驳回
     * @param topic
     * @return
     */
    @PostMapping(value = "/outreject")
    public ResponseVO outreject(ActTopicConditionVO topic) {
        topic.setApplyStatus(ActTopic.ACTTOPIC_STATUS_OUT);
        Integer integer = actTopicService.updateById(topic);
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
    public ResponseVO inreject(ActTopicConditionVO topic) {
        topic.setApplyStatus(ActTopic.ACTTOPIC_STATUS_IN);
        Integer integer = actTopicService.updateById(topic);
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
    public ResponseVO seedetail(ActTopicConditionVO topic) {
        ActTopicBo acttopicBo = actTopicService.seedetail(topic);
        return ResultUtil.success("1", acttopicBo);
    }


}

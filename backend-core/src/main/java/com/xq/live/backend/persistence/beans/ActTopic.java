package com.xq.live.backend.persistence.beans;

import com.xq.live.backend.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * 参与活动的视频文章审核
 * Created by ss on 2018/7/17.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "act_topic")
public class ActTopic extends AbstractDO {

    /*1视频通过 ，2视频不通过*/
    public final static int ACTTOPIC_STATUS_IN = 1;
    public final static int ACTTOPIC_STATUS_OUT = 2;

    private Long actId;
    private Long topicId;
    private String actTopicCode;
    private Long userId;
    private Integer applyStatus;
    private Integer voteNum;


    @Transient
    private String mobile;
    @Transient
    private String nickName;




}

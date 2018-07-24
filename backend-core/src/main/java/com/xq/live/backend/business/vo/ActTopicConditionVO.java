package com.xq.live.backend.business.vo;

import com.xq.live.backend.framework.object.BaseConditionVO;
import java.util.Date;

/**
 * Created by ss on 2018/7/17.
 */
public class ActTopicConditionVO extends BaseConditionVO {

    private Long id;
    private Date createTime;
    private Date updateTime;

    private Long actId;
    private Long topicId;
    private String actTopicCode;
    private Long userId;
    private Integer applyStatus;
    private Integer voteNum;

    private String mobile;
    private String nickName;


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getActId() {
        return actId;
    }

    public void setActId(Long actId) {
        this.actId = actId;
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public String getActTopicCode() {
        return actTopicCode;
    }

    public void setActTopicCode(String actTopicCode) {
        this.actTopicCode = actTopicCode;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(Integer applyStatus) {
        this.applyStatus = applyStatus;
    }

    public Integer getVoteNum() {
        return voteNum;
    }

    public void setVoteNum(Integer voteNum) {
        this.voteNum = voteNum;
    }
}

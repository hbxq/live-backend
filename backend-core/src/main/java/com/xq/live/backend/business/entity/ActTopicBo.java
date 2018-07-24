package com.xq.live.backend.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xq.live.backend.framework.object.AbstractBO;
import com.xq.live.backend.persistence.beans.ActTopic;

import java.util.Date;

/**
 * Created by ss on 2018/7/17.
 */
public class ActTopicBo extends AbstractBO {

    private ActTopic actTopic;

    public ActTopicBo() {
        this.actTopic = new ActTopic();
    }

    public ActTopicBo(ActTopic actTopic) {
        this.actTopic = actTopic;
    }

    @JsonIgnore
    public ActTopic getActTopic() {
        return this.actTopic;
    }


    public Long getId() {
        return this.actTopic.getId();
    }

    public void setId(Long id) {
        this.actTopic.setId(id);
    }

    public Date getCreateTime() {
        return this.actTopic.getCreateTime();
    }

    public void setCreateTime(Date createTime) {
        this.actTopic.setCreateTime(createTime);
    }

    public Date getUpdateTime() {
        return this.actTopic.getUpdateTime();
    }

    public void setUpdateTime(Date updateTime) {
        this.actTopic.setUpdateTime(updateTime);
    }

    public Long getActId() {
        return this.actTopic.getActId();
    }

    public void setActId(Long actId) {
        this.actTopic.setActId(actId);
    }

    public Long getTopicId() {
        return this.actTopic.getTopicId();
    }

    public void setTopicId(Long topicId) {
        this.actTopic.setTopicId(topicId);
    }

    public String getActTopicCode() {
        return this.actTopic.getActTopicCode();
    }

    public void setActTopicCode(String actTopicCode) {
        this.actTopic.setActTopicCode(actTopicCode);
    }

    public Long getUserId() {
        return this.actTopic.getUserId();
    }

    public void setUserId(Long userId) {
        this.actTopic.setUserId(userId);
    }

    public Integer getApplyStatus() {
        return this.actTopic.getApplyStatus();
    }

    public void setApplyStatus(Integer applyStatus) {
        this.actTopic.setApplyStatus(applyStatus);
    }

    public Integer getVoteNum() {
        return this.actTopic.getVoteNum();
    }

    public void setVoteNum(Integer voteNum) {
        this.actTopic.setVoteNum(voteNum);
    }

    public String getMobile() {
        return this.actTopic.getMobile();
    }

    public void setMobile(String mobile) {
        this.actTopic.setMobile(mobile);
    }

    public String getNickName() {
        return this.actTopic.getNickName();
    }

    public void setNickName(String nickName) {
        this.actTopic.setNickName(nickName);
    }
}

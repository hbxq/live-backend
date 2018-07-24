package com.xq.live.backend.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xq.live.backend.framework.object.AbstractBO;
import com.xq.live.backend.persistence.beans.Topic;

import java.util.Date;

/**
 * Created by ss on 2018/7/14.
 */
public class TopicBo extends AbstractBO {

    private Topic topic;
    public TopicBo() {
        this.topic = new Topic();
    }
    public TopicBo(Topic topic) {
        this.topic = topic;
    }
    @JsonIgnore
    public Topic getTopic() {
        return this.topic;
    }

    public Long getId() {
        return this.topic.getId();
    }

    public void setId(Long id) {
        this.topic.setId(id);
    }

    public Date getCreateTime() {
        return this.topic.getCreateTime();
    }

    public void setCreateTime(Date createTime) {
        this.topic.setCreateTime(createTime);
    }

    public Date getUpdateTime() {
        return this.topic.getUpdateTime();
    }

    public void setUpdateTime(Date updateTime) {
        this.topic.setUpdateTime(updateTime);
    }

    public String getTitle() {
        return this.topic.getTitle();
    }

    public void setTitle(String title) {
        this.topic.setTitle(title);
    }

    public String getContent() {
        return this.topic.getContent();
    }

    public void setContent(String content) {
        this.topic.setContent(content);
    }

    public String getSummary() {
        return this.topic.getSummary();
    }

    public void setSummary(String summary) {
        this.topic.setSummary(summary);
    }

    public String getHomePic() {
        return this.topic.getHomePic();
    }

    public void setHomePic(String homePic) {
        this.topic.setHomePic(homePic);
    }

    public String getPicIds() {
        return this.topic.getPicIds();
    }

    public void setPicIds(String picIds) {
        this.topic.setPicIds(picIds);
    }

    public Long getUserId() {
        return this.topic.getUserId();
    }

    public void setUserId(Long userId) {
        this.topic.setUserId(userId);
    }

    public String getUserName() {
        return this.topic.getUserName();
    }

    public void setUserName(String userName) {
        this.topic.setUserName(userName);
    }

    public Integer getIsDeleted() {
        return this.topic.getIsDeleted();
    }

    public void setIsDeleted(Integer isDeleted) {
        this.topic.setIsDeleted(isDeleted);
    }

    public Integer getTpStatus() {
        return this.topic.getTpStatus();
    }

    public void setTpStatus(Integer tpStatus) {
        this.topic.setTpStatus(tpStatus);
    }

    public String getNickName() {
        return this.topic.getNickName();
    }

    public void setNickName(String nickName) {
        this.topic.setNickName(nickName);
    }

    public Integer getHitNum() {
        return this.topic.getHitNum();
    }

    public void setHitNum(Integer hitNum) {
        this.topic.setHitNum(hitNum);
    }

    public Integer getTopicType() {
        return this.topic.getTopicType();
    }

    public void setTopicType(Integer topicType) {
        this.topic.setTopicType(topicType);
    }

    public Integer getTransNum() {
        return this.topic.getTransNum();
    }

    public void setTransNum(Integer transNum) {
        this.topic.setTransNum(transNum);
    }

    public Long getActId() {
        return this.topic.getActId();
    }

    public void setActId(Long actId) {
        this.topic.setActId(actId);
    }

    public String getActName() {
        return this.topic.getActName();
    }

    public void setActName(String actName) {
        this.topic.setActName(actName);
    }
}

package com.xq.live.backend.persistence.beans;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xq.live.backend.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

/**
 * 视频文章审核
 * Created by ss on 2018/7/13.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "topic")
public class Topic extends AbstractDO {

    /*1视频通过 ，2视频不通过*/
    public final static int TOPIC_STATUS_IN = 1;
    public final static int TOPIC_STATUS_OUT = 2;


    private String title;
    private String content;
    private String summary;     //摘要
    private String homePic;     //封面
    private String picIds;  //主题包含的图片id
    private Long userId;
    private String userName;
    private Integer isDeleted;
    private Integer tpStatus;
    private String nickName;
    private Integer hitNum;
    private Integer topicType;//文章类型
    private Integer transNum;//转发量

    @Transient
    private List<Attachment> picUrls;
    @Transient
    private Integer choiceType;//1是用户2是商家
    @Transient
    private Long actId;//活动id
    @Transient
    private String actName;//活动名

}

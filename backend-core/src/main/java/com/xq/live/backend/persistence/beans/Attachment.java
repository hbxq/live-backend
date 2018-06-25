package com.xq.live.backend.persistence.beans;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "attachment")
public class Attachment {
    private Long id;

    private String smallPicUrl;

    private String picUrl;

    private Integer sortNum;

    private Date createTime;
}

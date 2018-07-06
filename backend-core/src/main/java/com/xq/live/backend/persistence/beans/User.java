package com.xq.live.backend.persistence.beans;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xq.live.backend.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户
 * Created by ss on 2018/7/5.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "user")
public class User extends AbstractDO {

    private String userName;
    private String password;
    private String nickName;
    private String iconUrl;
    private String mobile;
    private BigDecimal locationX;
    private BigDecimal locationY;

    /**
     * 用户类型  1 普通用户 2 商家用户
     */
    private Integer userType;
    /**
     * 商家id
     */
    private Long shopId;
    @NotNull(message = "openId必填")
    private String openId;
    private String unionId;//多应用微信登录唯一标志
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastLoginTime;
    private String userIp;
    private Integer loginTimes; //记录用户登录次数
    private Integer sourceType;
    private Integer sex;    //性别 0 未知 1 男 2 女
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private Integer age;//年龄
    private Integer height;//身高

}

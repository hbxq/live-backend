package com.xq.live.backend.persistence.beans;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * com.xq.live.backend.persistence.beans
 *  商家实体映射
 * @author zhangpeng32
 * Created on 2018/5/23 下午4:32
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "shop")
public class Shop {
    private Long id;
    private String shopName;

    private String address;

    private String mobile;

    private String phone;

    private String indexUrl;

    private String logoUrl;

    private String shopInfo;

    private BigDecimal locationX;

    private BigDecimal locationY;

    private Integer isDeleted;

    private Integer popNum;

    private String remark;

    private Date createTime;

    private Date updateTime;

    private Long userId;       //店铺关联的账号id

    private Integer shopStatus;//店铺状态

    private Integer applyStatus;//审批状态

    private String businessCate;//经营品类
}

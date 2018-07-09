package com.xq.live.backend.persistence.beans;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xq.live.backend.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/*
*
* 商家入驻
* */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "shop_enter")
public class ShopEnter  extends AbstractDO {
    private String userName;//用户名称
    private String mobile;//联系方式
    private String shopName;//店铺名称
    private String address;//店铺地址
    private String businessCate;//经营品类
    private String licensePic;//营业执照
    private String healthPic;//卫生许可证
    private String doorPic;//门头照
    private Long userId;//用户id
    private Integer status;//审核状态 0 待审批 1 审批通过 2审批不通过
    private BigDecimal locationX;//经度
    private BigDecimal locationY;//维度
    private String city;//城市

    private String logoPic;//logo
    private String shopHours;//营业时间
    private String otherService;//其他服务
    private String remark;//备注
}

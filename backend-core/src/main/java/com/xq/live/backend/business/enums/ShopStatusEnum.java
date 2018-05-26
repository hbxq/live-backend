package com.xq.live.backend.business.enums;

/**
 * com.xq.live.backend.business.enums
 *
 * @author zhangpeng32
 * Created on 2018/5/25 上午9:59
 * @Description:
 */
public enum ShopStatusEnum {
    NORMAL(1, "正常"),
    DISABLE(2, "冻结"),;
    private Integer code;
    private String desc;

    ShopStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static ShopStatusEnum get(Integer code) {
        if (null == code) {
            return NORMAL;
        }
        ShopStatusEnum[] enums = ShopStatusEnum.values();
        for (ShopStatusEnum anEnum : enums) {
            if (anEnum.getCode().equals(code)) {
                return anEnum;
            }
        }
        return NORMAL;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}

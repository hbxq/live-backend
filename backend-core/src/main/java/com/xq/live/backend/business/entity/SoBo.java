package com.xq.live.backend.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xq.live.backend.framework.object.AbstractBO;
import com.xq.live.backend.persistence.beans.Shop;
import com.xq.live.backend.persistence.beans.So;
import com.xq.live.backend.persistence.beans.SoDetail;

/**
 * com.xq.live.backend.business.entity
 *  订单业务对象
 * @author zhangpeng32
 * Created on 2018/5/26 下午5:53
 * @Description:
 */
public class SoBo extends AbstractBO {
    private So so;

    public SoBo() {
        this.so = new So();
    }

    public SoBo(Shop shop) {
        this.so = so;
    }

    @JsonIgnore
    public So getSo() {
        return this.so;
    }


}

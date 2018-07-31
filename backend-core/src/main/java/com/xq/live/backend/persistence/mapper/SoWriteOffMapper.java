package com.xq.live.backend.persistence.mapper;

import com.xq.live.backend.business.vo.SoWriteOffInVo;
import com.xq.live.backend.persistence.beans.SoWriteOff;
import com.xq.live.backend.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SoWriteOffMapper  extends BaseMapper<SoWriteOff> {

    /**
     * 分页查询商家核销票券（所有的票券）
     * @param vo
     * @return
     */
    List<SoWriteOff> selectofflist(SoWriteOffInVo vo);

    /**
     * 根据shopid和时间批量更改商家訂單
     * @param vo
     * @return
     */
    Integer updateByShopId(SoWriteOffInVo vo);

    /**
     * 分页查询商家核销票券（未结算的票券）
     * @param vo
     * @return
     */
    List<SoWriteOff> selectoffbill(SoWriteOffInVo vo);


}

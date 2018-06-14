package com.xq.live.backend.business.service;


import com.github.pagehelper.PageInfo;
import com.xq.live.backend.business.out.SoWriteOffOut;
import com.xq.live.backend.business.vo.SoWriteOffInVo;
import com.xq.live.backend.persistence.beans.SoWriteOff;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author zhangpeng32
 * @date 2018-02-21 18:32
 * @copyright:hbxq
 **/
public interface SoWriteOffService {
    /***
     * 分页查询
     * @param inVo
     * @return
     */
    PageInfo<SoWriteOffOut> list(SoWriteOffInVo inVo);

    /**
     * 根据商家ID查询指定年份内的所有账单记录
     * @param inVo
     * @return
     */
    List<SoWriteOffOut> listAmount(SoWriteOffInVo inVo);

    /**
     * 排序查询记录列表
     * @param inVo
     * @return
     */
    List<SoWriteOffOut> top(SoWriteOffInVo inVo);

    /**
     * 查询一条记录
     * @param id
     * @return
     */
    SoWriteOff get(Long id);


    /**
     * 查询一段时间内商家核销票数
     * @param inVo
     * @return
     */
    int listTotal(SoWriteOffInVo inVo);

    /**
     * 修改商家一段时间内核销券的对账状态
     * @param inVo
     * @return
     */
    Integer shopSoByBill(List<SoWriteOffInVo> inVo);
}

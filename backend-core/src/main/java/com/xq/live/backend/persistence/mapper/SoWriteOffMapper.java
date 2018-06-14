package com.xq.live.backend.persistence.mapper;

import com.xq.live.backend.business.out.SoWriteOffOut;
import com.xq.live.backend.business.vo.SoWriteOffInVo;
import com.xq.live.backend.persistence.beans.SoWriteOff;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SoWriteOffMapper {

    int insert(SoWriteOff record);

    SoWriteOff selectByPrimaryKey(Long id);

    List<SoWriteOffOut> list(SoWriteOffInVo inVo);

    int listTotal(SoWriteOffInVo inVo);

    List<SoWriteOffOut> total(SoWriteOffInVo inVo);

    Integer shopSoByBill(List<SoWriteOffInVo> inVo);
}

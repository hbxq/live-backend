package com.xq.live.backend.persistence.mapper;


import com.xq.live.backend.business.vo.ShopAllocationVO;
import com.xq.live.backend.persistence.beans.ShopAllocation;
import com.xq.live.backend.plugin.BaseMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ShopAllocationMapper  extends BaseMapper<ShopAllocation> {
    int insertAllShop(ShopAllocationVO record);
}
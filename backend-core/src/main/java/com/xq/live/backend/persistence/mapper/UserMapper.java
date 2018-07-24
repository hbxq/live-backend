package com.xq.live.backend.persistence.mapper;

import com.xq.live.backend.business.vo.UserVO;
import com.xq.live.backend.persistence.beans.ShopEnter;
import com.xq.live.backend.persistence.beans.User;
import com.xq.live.backend.plugin.BaseMapper;

/**
 * Created by ss on 2018/7/5.
 */
public interface UserMapper  extends BaseMapper<ShopEnter> {

    int updateUserType(UserVO record);

    User selectByid(Long id);

    Long selectByshopid(Long shopId);
}

package com.xq.live.backend.persistence.mapper;

import com.xq.live.backend.business.vo.UserAccountConditionVO;
import com.xq.live.backend.persistence.beans.UserAccount;
import com.xq.live.backend.plugin.BaseMapper;

/**
 * Created by ss on 2018/7/18.
 */
public interface UserAccountMapper  extends BaseMapper<UserAccount>{

    UserAccount findAccountByUserId(Long id);

    Integer amoutForUserid(UserAccountConditionVO vo);
}

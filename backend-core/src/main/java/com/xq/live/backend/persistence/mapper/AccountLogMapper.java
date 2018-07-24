package com.xq.live.backend.persistence.mapper;


import com.xq.live.backend.business.vo.AccountLogConditionVO;
import com.xq.live.backend.persistence.beans.AccountLog;
import com.xq.live.backend.plugin.BaseMapper;

/**
 * Created by ss on 2018/7/18.
 */
public interface AccountLogMapper extends BaseMapper<AccountLog> {

    int billLog(AccountLogConditionVO invo);

}

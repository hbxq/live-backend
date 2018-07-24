package com.xq.live.backend.controller;

import com.github.pagehelper.PageInfo;
import com.xq.live.backend.business.entity.CashApplyBo;
import com.xq.live.backend.business.service.CashApplyService;
import com.xq.live.backend.business.vo.CashApplyConditionVO;
import com.xq.live.backend.framework.object.PageResult;
import com.xq.live.backend.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ss on 2018/7/19.
 */
@RestController
@RequestMapping("/cash")
public class RestCashApplyController {

@Autowired
private CashApplyService cashApplyService;

    /**
     * 加载初始化表数据和查询列表
     *
     * @param invo
     * @return
     */
    @PostMapping(value = "/seelist")
    public PageResult topiclist(CashApplyConditionVO invo) {
        PageInfo<CashApplyBo> pageInfo = cashApplyService.selectBykeywords(invo);
        return ResultUtil.tablePage(pageInfo);
    }
}

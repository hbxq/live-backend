package com.xq.live.backend.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xq.live.backend.business.entity.ShopBo;
import com.xq.live.backend.business.service.ShopService;
import com.xq.live.backend.business.vo.ShopConditionVO;
import com.xq.live.backend.framework.object.PageResult;
import com.xq.live.backend.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.xq.live.backend.controller
 *
 * @author zhangpeng32
 * Created on 2018/6/14 下午9:00
 * @Description:
 */
@RestController
@RequestMapping("/bill")
public class RestBillController {
    @Autowired
    private ShopService shopService;

    @PostMapping("/list")
    public PageResult list(ShopConditionVO vo) {
        PageHelper.startPage(vo.getPageNumber() - 1, vo.getPageSize());
        PageInfo<ShopBo> pageInfo = shopService.findPageBreakByCondition(vo);
        return ResultUtil.tablePage(pageInfo);
    }

    @PostMapping("/detail")
    public PageResult details(ShopConditionVO vo){
        PageHelper.startPage(vo.getPageNumber() - 1, vo.getPageSize());
        PageInfo<ShopBo> pageInfo = shopService.findPageBreakByCondition(vo);
        return ResultUtil.tablePage(pageInfo);
    }
}

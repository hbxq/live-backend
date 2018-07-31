package com.xq.live.backend.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xq.live.backend.business.entity.ServiceAmountBo;
import com.xq.live.backend.business.service.ServiceAmountService;
import com.xq.live.backend.business.vo.ServiceAmountVO;
import com.xq.live.backend.framework.object.PageResult;
import com.xq.live.backend.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ss on 2018/7/28.
 */
@RestController
@RequestMapping("/amount")
public class RestServiceAmountController {


    @Autowired
    private ServiceAmountService serviceAmountService;

    /**
     * 查询一个商家服务费的信息
     * @param vo
     * @return
     */
    @PostMapping(value = "/getshopAmount")
    public PageResult list(ServiceAmountVO vo){
        PageHelper.startPage(vo.getPageNumber() - 1, vo.getPageSize());
        PageInfo<ServiceAmountBo> pageInfo=serviceAmountService.findShopService(vo);
        return ResultUtil.tablePage(pageInfo);
    }



}

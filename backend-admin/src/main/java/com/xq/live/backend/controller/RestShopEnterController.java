package com.xq.live.backend.controller;

import com.xq.live.backend.business.service.ShopEnterService;
import com.xq.live.backend.business.vo.ShopEnterVO;
import com.xq.live.backend.framework.object.ResponseVO;
import com.xq.live.backend.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ss on 2018/7/6.
 */
@RestController
@RequestMapping("/enter")
public class RestShopEnterController {

    @Autowired
    private ShopEnterService shopEnterService;


    /**
     *   审批通过后，插入shop表,更改user状态
     * @param shopEnter
     * @return
     */
    @PostMapping(value = "/addShop")
    public ResponseVO add(ShopEnterVO shopEnter) {
        if(shopEnter==null||shopEnter.getUserId()==null||shopEnter.getShopName()==null){
            return ResultUtil.error("缺少参数");
        }
        Integer integer = shopEnterService.addShop(shopEnter);
        if(integer==null){
            return  ResultUtil.error("查询结果异常");
        }
        return ResultUtil.success("审核通过-成功入驻");
    }

    /**
     *   审批通过后，插入shop表,更改user状态
     * @param shopEnter
     * @return
     */
    @PostMapping(value = "/list")
    public ResponseVO seelist(ShopEnterVO shopEnter) {

        Integer integer = shopEnterService.addShop(shopEnter);
        if(integer==null){
            return  ResultUtil.error("查询结果异常");
        }
        return ResultUtil.success("审核通过-成功入驻");
    }


}

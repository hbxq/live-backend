package com.xq.live.backend.controller;

import com.github.pagehelper.PageInfo;
import com.xq.live.backend.business.entity.ShopEnterBo;
import com.xq.live.backend.business.service.ShopEnterService;
import com.xq.live.backend.business.vo.ShopEnterVO;
import com.xq.live.backend.framework.object.PageResult;
import com.xq.live.backend.framework.object.ResponseVO;
import com.xq.live.backend.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商家入驻审核业务
 * Created by ss on 2018/7/6.
 */
@RestController
@RequestMapping("/enter")
public class RestShopEnterController {

    @Autowired
    private ShopEnterService shopEnterService;

    /**
     * 加载初始化表数据和查询列表
     *
     * @param shopEnter
     * @return
     */
    @PostMapping(value = "/seelist")
    public PageResult seelist(ShopEnterVO shopEnter) {
        PageInfo<ShopEnterBo> pageInfo = shopEnterService.selectBytemp(shopEnter);
        return ResultUtil.tablePage(pageInfo);
    }

    /**
     * 查看明细
     *
     * @param shopEnter
     * @return
     */
    @PostMapping(value = "/detail")
    public ResponseVO seedetail(ShopEnterVO shopEnter) {
        ShopEnterBo shopEnterBo = shopEnterService.seedetail(shopEnter);
        return ResultUtil.success("1", shopEnterBo);
    }



    /**
     *  审批通过后，插入shop表,更改user状态
     *
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
        return ResultUtil.success("审核通过-成功入驻", integer);
    }


    /**
     * @param shopEnter
     * @return
     */
    @PostMapping(value = "/toremark")
    public ResponseVO toremark(ShopEnterVO shopEnter) {
        Integer integer = shopEnterService.updateById(shopEnter);
        if(integer==0){
            return  ResultUtil.error("修改失败");
        }
        return ResultUtil.success("编写成功");
    }

    /**
     * @param shopEnter
     * @return
     */
    @PostMapping(value = "/toreject")
    public ResponseVO toreject(ShopEnterVO shopEnter) {
        Integer integer = shopEnterService.updateById(shopEnter);
        if(integer==0){
            return  ResultUtil.error("修改失败");
        }
        return ResultUtil.success("商家未通过审核");
    }
}

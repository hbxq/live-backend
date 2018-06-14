package com.xq.live.backend.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xq.live.backend.business.entity.User;
import com.xq.live.backend.business.enums.ResponseStatus;
import com.xq.live.backend.business.service.ShopService;
import com.xq.live.backend.business.vo.ShopConditionVO;
import com.xq.live.backend.framework.object.PageResult;
import com.xq.live.backend.framework.object.ResponseVO;
import com.xq.live.backend.persistence.beans.Shop;
import com.xq.live.backend.util.PasswordUtil;
import com.xq.live.backend.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * com.xq.live.backend.controller
 *
 * @author zhangpeng32
 * Created on 2018/5/24 上午10:53
 * @Description:
 */
@RestController
@RequestMapping("/shop")
public class RestShopController {
    @Autowired
    private ShopService shopService;

    @PostMapping("/list")
    public PageResult list(ShopConditionVO vo) {
        PageHelper.startPage(vo.getPageNumber() - 1, vo.getPageSize());
        PageInfo<Shop> pageInfo = shopService.findPageBreakByCondition(vo);
        return ResultUtil.tablePage(pageInfo);
    }


    @PostMapping(value = "/add")
    public ResponseVO add(Shop shop) {
        shop.setIsDeleted(0);
        shop.setShopStatus(1);
        return ResultUtil.success("成功");
    }

    /**
     * 根据商家名查询
     * @param
     * @return
     */
    @GetMapping(value = "/getByName")
     public ResponseVO getByShopName(String name){
        Shop shop=shopService.findBreakByName(name);
        if (shop!=null){
            return ResultUtil.success("查询有值",shop);
        }else {
            return ResultUtil.error("没有此商家,请检查输入信息");
        }
    }

    /**
     * 根据商家名模糊查询
     * @param
     * @return
     */
    @GetMapping(value = "/fuzzyByName")
    public ResponseVO fuzzyByShopName(String name){
        List<Shop> shop=shopService.findfuzzyByName(name);
        if (shop!=null||shop.size()>0){
            return ResultUtil.success("查询有值",shop);
        }else {
            return ResultUtil.error("没有此商家,请检查输入信息");
        }
    }
    /**
     * 根据Userid查询
     * @param
     * @return
     */
    @GetMapping(value = "/getByUserId")
    public ResponseVO getByUserId(Long id){
        Shop shop = shopService.findBreakByUserId(id);
        if (shop!=null){
            return ResultUtil.success("查询有值",shop);
        }else {
            return ResultUtil.error("没有此商家,请检查输入信息");
        }
    }

    /**
     * 根据商家id查询
     * @param
     * @return
     */
    @GetMapping(value = "/getByShopId")
    public ResponseVO getByShopId(Long id){
        Shop shop = shopService.findBreakByShopId(id);
        if (shop!=null){
            return ResultUtil.success("查询有值",shop);
        }else {
            return ResultUtil.error("没有此商家,请检查输入信息");
        }
    }

    /**
     * 添加商家
     * @param
     * @return
     */
    @PostMapping(value = "/addInfo")
    public ResponseVO addShopInfo(Shop shop) {
        shop.setIsDeleted(0);
        shop.setShopStatus(1);
        int i=shopService.insertShopInfo(shop);
        if (i==1){
            return ResultUtil.success("添加成功");
        }
        return ResultUtil.error("添加商家信息失败!");
    }

    /**
     * 修改商家
     * @param
     * @return
     */
    @PostMapping(value = "/upInfoById")
    public ResponseVO upShopInfo(Shop shop) {
        int i=shopService.changeShopInfo(shop);
        if (i==1){
            return ResultUtil.success("修改成功");
        }
        return ResultUtil.error("修改商家信息失败!");
    }
    /**
     * 批量删除商家
     * @param
     * @return
     */
    @PostMapping(value = "/rmInfoById")
    public ResponseVO deShopById(List<Shop> id) {
        int i=shopService.deleteShopByID(id);
        if (i==1){
            return ResultUtil.success("删除成功");
        }
        return ResultUtil.error("删除商家信息失败!");
    }

    @PostMapping("/get/{id}")
    public ResponseVO get(@PathVariable Long id) {
        return ResultUtil.success(null, this.shopService.getByPrimaryKey(id));
    }

    @PostMapping("/edit")
    public ResponseVO edit(Shop shop) {
        try {
            shopService.updateSelective(shop);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("商家修改失败！");
        }
        return ResultUtil.success(ResponseStatus.SUCCESS);
    }
}

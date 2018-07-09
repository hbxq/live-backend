package com.xq.live.backend.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xq.live.backend.business.entity.ShopBo;
import com.xq.live.backend.business.enums.ResponseStatus;
import com.xq.live.backend.business.service.ShopService;
import com.xq.live.backend.business.vo.ShopConditionVO;
import com.xq.live.backend.framework.object.PageResult;
import com.xq.live.backend.framework.object.ResponseVO;
import com.xq.live.backend.persistence.beans.Shop;
import com.xq.live.backend.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



/**
 * com.xq.live.backend.controller
 *商家管理
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
        PageInfo<ShopBo> pageInfo = shopService.findPageBreakByCondition(vo);
        return ResultUtil.tablePage(pageInfo);
    }


    @PostMapping(value = "/add")
    public ResponseVO add(Shop shop) {
        shopService.insert(new ShopBo(shop));
        return ResultUtil.success("成功");
    }

    /**
     * 逻辑删除商家信息
     * @param ids
     * @return
     */
    @PostMapping(value = "/remove")
    public ResponseVO remove(Long[] ids){
        if (null == ids) {
            return ResultUtil.error(500, "请至少选择一条记录");
        }
        for (Long id : ids) {
            ShopBo byPrimaryKey = shopService.getByPrimaryKey(id);
            byPrimaryKey.setIsDeleted(Shop.IS_DELETED);
            boolean b = shopService.updateSelective(byPrimaryKey);
        }
        return ResultUtil.success("成功删除 [" + ids.length + "] 个商家");
    }

    @PostMapping("/get/{id}")
    public ResponseVO get(@PathVariable Long id) {
        return ResultUtil.success(null, this.shopService.getByPrimaryKey(id));
    }

    @PostMapping("/edit")
    public ResponseVO edit(ShopBo shopBo) {
        try {
            shopService.updateSelective(shopBo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("商家修改失败！");
        }
        return ResultUtil.success(ResponseStatus.SUCCESS);
    }
}

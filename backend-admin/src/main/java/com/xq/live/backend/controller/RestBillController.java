package com.xq.live.backend.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xq.live.backend.business.entity.ShopBo;
import com.xq.live.backend.business.entity.SoBo;
import com.xq.live.backend.business.entity.SoWriteOffBo;
import com.xq.live.backend.business.service.SoService;
import com.xq.live.backend.business.vo.SoConditionVO;
import com.xq.live.backend.business.service.ShopService;
import com.xq.live.backend.business.service.SoWriteOffService;
import com.xq.live.backend.business.vo.ShopConditionVO;
import com.xq.live.backend.business.vo.SoWriteOffInVo;
import com.xq.live.backend.framework.object.PageResult;
import com.xq.live.backend.framework.object.ResponseVO;
import com.xq.live.backend.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * com.xq.live.backend.controller
 *订单对账，核销结算
 * @author zhangpeng32
 * Created on 2018/6/14 下午9:00
 * @Description:
 */
@RestController
@RequestMapping("/bill")
public class RestBillController {
    @Autowired
    private ShopService shopService;

    @Autowired
    private SoWriteOffService soWriteOffService;

    @Autowired
    private SoService soService;

    @PostMapping("/list")
    public PageResult list(ShopConditionVO vo) {
        PageHelper.startPage(vo.getPageNumber() - 1, vo.getPageSize());
        PageInfo<ShopBo> pageInfo = shopService.findPageBreakByCondition(vo);
        return ResultUtil.tablePage(pageInfo);
    }

    /**
     * 查询每个商家核销的票卷的信息
     * @param vo
     * @return
     */
    @PostMapping(value = "/getSoWriteOfflist")
    public  PageResult list(SoWriteOffInVo vo){
        PageHelper.startPage(vo.getPageNumber() - 1, vo.getPageSize());
        PageInfo<SoWriteOffBo> pageInfo=soWriteOffService.findSoForShop(vo);
        return ResultUtil.tablePage(pageInfo);
    }

    /**
     * 查询一个商家一段时间内的订单信息
     * @param vo
     * @return
     */
    @PostMapping("/sotimeList")
    public PageResult soList(SoConditionVO vo) {
        PageHelper.startPage(vo.getPageNumber() - 1, vo.getPageSize());
        PageInfo<SoBo> pageInfo = soService.findSoForShop(vo);
        return ResultUtil.tablePage(pageInfo);
    }

    /**
     * 订单合计
     * @param vo
     * @return
     */
    @PostMapping("/soPrice")
    public SoBo soPrice(SoConditionVO vo) {
        SoBo pageInfo = soService.findSoShop(vo);
        return pageInfo;
    }

    /**
     * 核销合计
     * @param vo
     * @return
     */
    @PostMapping("/writePrice")
    public SoWriteOffBo writePrice(SoWriteOffInVo vo) {
        SoWriteOffBo soWriteOffBo = soWriteOffService.findSoShop(vo);
        return soWriteOffBo;
    }

    /**
     * 批量修改一个商家时间段内符合条件的的订单信息
     * @param inVo
     * @return
     */
    @PostMapping("/updateSoList")
    public ResponseVO updateList(SoConditionVO inVo) {
        Integer i=soService.updateByShopId(inVo);
        if (i>0){
         return  ResultUtil.success("成功修改"+i+"条数据",i);
        }
        return ResultUtil.error(0,"修改失败!");
    }

    /**
     * 批量修改一个商家时间段内符合条件的的核销信息
     * @param inVo
     * @return
     */
    @PostMapping("/updateWriteList")
    public ResponseVO updateWrite(SoWriteOffInVo inVo) {
        Integer i=soWriteOffService.updateByShopId(inVo);
        if (i>0){
            return  ResultUtil.success("成功修改"+i+"条数据",i);
        }
        return ResultUtil.error(0,"修改失败!");
    }


}

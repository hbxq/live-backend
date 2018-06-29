package com.xq.live.backend.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xq.live.backend.business.entity.ShopBo;
import com.xq.live.backend.business.entity.SoBo;
import com.xq.live.backend.business.service.SoService;
import com.xq.live.backend.business.vo.SoConditionVO;
import com.xq.live.backend.persistence.beans.SoWriteOff;
import com.xq.live.backend.business.service.ShopService;
import com.xq.live.backend.business.service.SoWriteOffService;
import com.xq.live.backend.business.vo.ShopConditionVO;
import com.xq.live.backend.business.vo.SoWriteOffInVo;
import com.xq.live.backend.framework.object.PageResult;
import com.xq.live.backend.framework.object.ResponseVO;
import com.xq.live.backend.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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
     * @param inVo
     * @return
     */
    @RequestMapping(value = "/getlist",method = RequestMethod.POST)
    public  PageResult list(SoWriteOffInVo inVo){
        if(inVo==null||inVo.getSoWrite().getShopId()==null){
            return null;
        }
        return null;
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
        System.out.println(pageInfo);
        return ResultUtil.tablePage(pageInfo);
    }

    /**
     * 批量修改一个商家符合条件的的订单信息
     * @param list
     * @return
     */
    @PostMapping("/slsl")
    public ResponseVO soList(List<SoConditionVO> list) {
        Integer i=soService.updateBySO(list);
        if (i>0){
         return  ResultUtil.success("修改成功",i);
        }
        return ResultUtil.error(0,"修改失败");
    }

    @PostMapping("/detail")
    public PageResult details(ShopConditionVO vo){
        PageHelper.startPage(vo.getPageNumber() - 1, vo.getPageSize());
        PageInfo<ShopBo> pageInfo = shopService.findPageBreakByCondition(vo);
        return ResultUtil.tablePage(pageInfo);
    }

    /**
     * 修改商家时间段内的核销对账状态
     * @param
     * @return
     */
/*
    @SuppressWarnings("unchecked")
    @ResponseBody
    @RequestMapping(value = "/shopSoByBill",method = RequestMethod.POST)
    public ResponseVO shopSoByBill(HttpServletRequest request){
        HttpSession session = request.getSession();
        String list="{\"shopBill\":"+request.getParameter("shopBill")+"}";
        List<SoWriteOffInVo> inVo = new ArrayList<SoWriteOffInVo>();
        JSONObject jso= JSON.parseObject(list);
        //System.out.println("初始jsonObject:\n"+jso+"\n");
        JSONArray jsarr=jso.getJSONArray("shopBill");
        for(int i=0;i<jsarr.size();i++){
            JSONObject ao = jsarr.getJSONObject(i);
            inVo.get(i).setShopId(ao.getLong("shopId"));
            inVo.get(i).setIsBill(ao.getInteger("isBill"));
            inVo.get(i).setSoId(ao.getLong("soId"));
        }
        Integer result=soWriteOffService.shopSoByBill(inVo);
        if (result!=null){
            return ResultUtil.success("修改成功",result);
        }
        return ResultUtil.error("修改失败");
    }
*/

}

package com.xq.live.backend.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.xq.live.backend.business.out.SoWriteOffOut;
import com.xq.live.backend.business.service.SoWriteOffService;
import com.xq.live.backend.business.vo.SoWriteOffInVo;
import com.xq.live.backend.framework.object.PageResult;
import com.xq.live.backend.framework.object.ResponseVO;

import com.xq.live.backend.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
/**
 * ${DESCRIPTION}
 *
 * @author lipeng
 * @date 2018-02-21 18:18
 * @copyright:hbxq
 **/
@RestController
@RequestMapping(value = "/hx")
public class RestSoShopBIll {

    @Autowired
    private SoWriteOffService soWriteOffService;

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpServletResponse response;

    /**
     * 查询每个商家核销的票卷的信息
     * @param inVo
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public  PageResult list(SoWriteOffInVo inVo){
        if(inVo==null||inVo.getShopId()==null||inVo.getBegainTime()==null||inVo.getEndTime()==null){
            return null;
        }
        PageHelper.startPage(inVo.getPage() - 1, inVo.getRows());
        PageInfo<SoWriteOffOut> pageInfo = soWriteOffService.list(inVo);
        return ResultUtil.tablePage(pageInfo);
    }

    /**
     * 修改商家时间段内的核销对账状态
     * @param
     * @return
     */
    @SuppressWarnings("unchecked")
    @ResponseBody
    @RequestMapping(value = "/shopSoByBill",method = RequestMethod.POST)
    public ResponseVO shopSoByBill(HttpServletRequest reuq){
        HttpSession session = request.getSession();
        String list="{\"shopBill\":"+reuq.getParameter("shopBill")+"}";
        List<SoWriteOffInVo> inVo = new ArrayList<SoWriteOffInVo>();
        JSONObject jso=JSON.parseObject(list);
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
}

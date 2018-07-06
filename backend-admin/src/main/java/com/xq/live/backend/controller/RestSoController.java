package com.xq.live.backend.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xq.live.backend.business.entity.ShopBo;
import com.xq.live.backend.business.entity.SoBo;
import com.xq.live.backend.business.service.SoService;
import com.xq.live.backend.business.vo.SoConditionVO;
import com.xq.live.backend.framework.object.PageResult;
import com.xq.live.backend.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * 订单业务
 * Created by lipeng on 2018/6/26.
 */
@RestController
@RequestMapping("/order")
public class RestSoController {
    @Autowired
    private SoService soService;

    /**
     * 分页查询
     * @param vo
     * @return
     */
    @PostMapping("/list")
    public PageResult list(SoConditionVO vo) {
        PageHelper.startPage(vo.getPageNumber() - 1, vo.getPageSize());
        PageInfo<SoBo> pageInfo = soService.findPageBreakByCondition(vo);
        return ResultUtil.tablePage(pageInfo);
    }
}

package com.xq.live.backend.controller;

import com.xq.live.backend.common.RedisCache;
import com.xq.live.backend.framework.object.ResponseVO;
import com.xq.live.backend.persistence.beans.User;
import com.xq.live.backend.util.ResultUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 缓存管理系统业务
 * Created by lipeng on 2018/7/12.
 */
@RestController
@RequestMapping("/cache")
public class RestCacheController {
    @Autowired
    private RedisCache redisCache;

    @PostMapping("/list")
    public ResponseVO list(String key){
        Map<Object, Object> map = redisCache.getList(key);
        return ResultUtil.success(null,map);
    }
}

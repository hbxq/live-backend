/**
 * MIT License
 * Copyright (c) 2018 ZhangPeng
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.xq.live.backend.controller;

/**
 * 页面渲染相关 -- 页面跳转
 *
 * @author ZhangPeng (rocky8023@163.com)
 * @version 1.0
 * @website htts://www.xiang7.net
 * @date 2018/4/24 14:37
 * @since 1.0
 */

import com.xq.live.backend.util.ResultUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 页面跳转类
 *
 * @author ZhangPeng (rocky8023@163.com)
 * @version 1.0
 * @website htts://www.xiang7.net
 * @date 2018/4/24 14:37
 * @since 1.0
 */
@Controller
public class RenderController {

    @GetMapping("")
    public ModelAndView home() {
        return ResultUtil.view("index");
    }

    @GetMapping("/index")
    public ModelAndView index() {
        return ResultUtil.view("index");
    }

    @GetMapping("/users")
    public ModelAndView user() {
        return ResultUtil.view("user/list");
    }

    @GetMapping("/resources")
    public ModelAndView resources() {
        return ResultUtil.view("resources/list");
    }

    @GetMapping("/roles")
    public ModelAndView roles() {
        return ResultUtil.view("role/list");
    }

    @GetMapping("/shops")
    public ModelAndView shops() {
        return ResultUtil.view("shop/list");
    }

    @GetMapping("/orders")
    public ModelAndView orders() {
        return ResultUtil.view("order/list");
    }

    @GetMapping("/bills")
    public ModelAndView bills() {
        return ResultUtil.view("bill/list");
    }
}

package com.dyc.controller;

import com.dyc.pojo.bo.ShopcartBO;
import com.dyc.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api(value = "购物车接口", tags = {"购物车接口相关的api"})
@RestController
@RequestMapping("shopcart")
public class ShopcartController {

    final static Logger logger = LoggerFactory.getLogger(ShopcartController.class);

    @ApiOperation(value = "添加商品到购物车", notes = "添加商品到购物车", httpMethod = "POST")
    @PostMapping("/add")
    public JSONResult add(
            @RequestParam String userId,
            @RequestBody ShopcartBO shopcartBO,
            HttpServletRequest request,
            HttpServletResponse response){
        if(StringUtils.isBlank(userId)){
            return JSONResult.errorMsg("");
        }
        System.out.println(shopcartBO);
        // TODO 前端用户在登陆的情况下，添加商品到购物车，会同时在后端同步购物车到redis
       return JSONResult.ok();
    }

    @ApiOperation(value = "从购物车中删除商品", notes = "从购物车中删除商品", httpMethod = "POST")
    @PostMapping("/del")
    public JSONResult del(
            @RequestParam String userId,
            @RequestParam String itemSpecId,
            HttpServletRequest request,
            HttpServletResponse response){

        if(StringUtils.isBlank(userId) || StringUtils.isBlank(itemSpecId)){
            return JSONResult.errorMsg("参数不能为空");
        }

        // TODO 用户在页面删除购物车中的商品数据，如果此时用户已经登陆，则需要同步删除后端购物车中的商品
        return JSONResult.ok();
    }
}

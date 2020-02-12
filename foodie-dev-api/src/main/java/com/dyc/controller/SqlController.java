package com.dyc.controller;

import com.dyc.pojo.sql.Instructions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "外部sql参数接口",tags = "外部sql参数接口")
@RestController
@RequestMapping("sql")
public class SqlController {

    @ApiOperation(value = "关系型数据库参数入口", notes = "关系型数据库参数入口", httpMethod = "POST")
    @GetMapping("/sqlParmes")
    public String sqlParmes(@RequestBody Instructions instructions){

        return "select * from tabname where 1=1";
    }
}

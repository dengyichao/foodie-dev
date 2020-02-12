package com.dyc.controller;

import com.dyc.pojo.Users;
import com.dyc.pojo.bo.UserBO;
import com.dyc.service.UserService;
import com.dyc.utils.CookieUtils;
import com.dyc.utils.JSONResult;
import com.dyc.utils.JsonUtils;
import com.dyc.utils.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api(value = "注册登录",tags = "用户注册登录的相关接口")
@RestController
@RequestMapping("passport")
public class PassportController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户名是否存在", notes = "用户名是否存在", httpMethod = "GET")
    @GetMapping("/usernameIsExist")
    public JSONResult usernameIsExist(@RequestParam String username){
        // 1. 判断用户名不能为空
        if(StringUtils.isBlank(username)){
            return JSONResult.errorMsg("用户名不能为空");
        }
        // 2. 查找注册名称是否存在
        boolean isExist = userService.queryUsernameIsExist(username);
        if(isExist){
            return JSONResult.errorMsg("用户名已经存在");
        }

        // 3. 请求成功，用户名没有重复
        return JSONResult.ok();
    }

    @ApiOperation(value = "用户注册", notes = "用户注册", httpMethod = "POST")
    @PostMapping("/regist")
    public JSONResult regist(@RequestBody UserBO userBO,HttpServletRequest request, HttpServletResponse response){
        String username = userBO.getUsername();
        String password = userBO.getPassword();
        String confirmPassword = userBO.getConfirmPassword();
        // 0. 判断用户密码不能为空
        if(StringUtils.isBlank(username)||StringUtils.isBlank(password)||StringUtils.isBlank(confirmPassword)){
            return JSONResult.errorMsg("用户名或密码不能为空");
        }
        // 1. 查询用户民是否存在
        boolean isExist = userService.queryUsernameIsExist(username);
        if(isExist){
            return JSONResult.errorMsg("用户名已经存在");
        }
        // 2. 密码长度不能少于6位
        if (password.length() < 6){
            return JSONResult.errorMsg("密码长度不能少于6");
        }
        // 3. 判断两次密码是否一致
        if (!password.equals(confirmPassword)){
            return JSONResult.errorMsg("两次密码输入不一样");
        }
        // 4. 实现注册
        Users user = userService.createUser(userBO);
        setNullPorpertyUsers(user);
        CookieUtils.setCookie(request,response,"user", JsonUtils.objectToJson(user),true);
        // TODO 生成用户token，存入redis会话
        // TODO 同步购物车数据
        return JSONResult.ok();
    }

    @ApiOperation(value = "用户登录", notes = "用户登录", httpMethod = "POST")
    @PostMapping("/login")
    public JSONResult login(@RequestBody UserBO userBO, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = userBO.getUsername();
        String password = userBO.getPassword();
        // 0. 判断用户密码不能为空
        if(StringUtils.isBlank(username)||StringUtils.isBlank(password)){
            return JSONResult.errorMsg("用户名或密码不能为空");
        }

        // 4. 实现注册
        Users user = userService.queryUserForLogin(username, MD5Utils.getMD5Str(password));
        if(null == user){
            return JSONResult.errorMsg("账户或密码不正确");
        }
        setNullPorpertyUsers(user);
        CookieUtils.setCookie(request,response,"user", JsonUtils.objectToJson(user),true);
        // TODO 生成用户token，存入redis会话
        // TODO 同步购物车数据
        return JSONResult.ok(user);
    }

    @ApiOperation(value = "用户退出登录", notes = "用户退出登录", httpMethod = "POST")
    @PostMapping("/logout")
    public JSONResult logout(@RequestParam String userId, HttpServletRequest request, HttpServletResponse response) throws Exception {
        CookieUtils.deleteCookie(request,response,"user");
        // TODO 用户退出登录，需要清空购物车
        // TODO 分布式会话中需要清除用户数据
        return JSONResult.ok();
    }

    private Users setNullPorpertyUsers(Users users){
        users.setPassword(null);
        users.setMobile(null);
        users.setEmail(null);
        users.setCreatedTime(null);
        users.setUpdatedTime(null);
        return users;
    }

}

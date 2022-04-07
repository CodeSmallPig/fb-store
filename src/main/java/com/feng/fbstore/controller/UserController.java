package com.feng.fbstore.controller;


import com.feng.fbstore.entity.User;
import com.feng.fbstore.exception.CodeException;
import com.feng.fbstore.service.UserService;
import com.feng.fbstore.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author feng
 * @since 2022-02-22
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public R login(@RequestBody User user) {
        //首先再次进行用户名和密码的验证
        String username = user.getUsername();
        String password = user.getPassword();
        if (username == "" || password == "") {
            return R.error(CodeException.MISSED_User_EXCEPTION.getStatus(),CodeException.MISSED_User_EXCEPTION.getMsg());
        }
        //将用户名和密码和数据库进行对比，找到对应的用户
        User userFind = userService.findUser(username,password);
        if (userFind == null) {  //说明账号密码不正确
            return R.error(CodeException.FALSED_User_EXCEPTION.getStatus(),CodeException.FALSED_User_EXCEPTION.getMsg());
        }
        //说明用户登录正常，则将用户名以及对应的用户类型返回给前端（username和status）
        return R.ok("成功登录！").put("username",username).put("status",userFind.getStatus());
    }




}


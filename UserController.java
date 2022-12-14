package com.springboot_rt.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.springboot_rt.entity.R;
import com.springboot_rt.entity.User;
import com.springboot_rt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public R login(HttpServletRequest request,@RequestBody  User user){

        String password = user.getPassword();

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapper.eq(User::getUsername,user.getUsername());

        User user1 = userService.getOne(queryWrapper);

        if(user1 == null) {
            return  R.error("用户名未找到");
        }
        if(!user1.getPassword().equals(password)){
            return R.error("密码错误，登录失败");
        }
        request.getSession().setAttribute("userid",user1.getId());

        return R.success(user1);
    }

}

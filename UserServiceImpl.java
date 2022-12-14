package com.springboot_rt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot_rt.entity.User;
import com.springboot_rt.mapper.UserMapper;
import com.springboot_rt.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}

package com.example.onlineschoolbebackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.onlineschoolbebackend.entity.User;
import com.example.onlineschoolbebackend.service.UserService;
import com.example.onlineschoolbebackend.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
* @author mayn
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-12-13 18:40:08
*/
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}





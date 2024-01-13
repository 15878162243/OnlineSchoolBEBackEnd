package com.example.onlineschoolbebackend.service;

import com.example.onlineschoolbebackend.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.transaction.Transactional;

/**
* @author mayn
* @description 针对表【user】的数据库操作Service
* @createDate 2023-12-13 18:40:08
*/
@Transactional
public interface UserService extends IService<User> {

}

package com.example.onlineschoolbebackend.service;

import com.example.onlineschoolbebackend.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.transaction.Transactional;

/**
* @author mayn
* @description 针对表【role】的数据库操作Service
* @createDate 2024-01-10 17:17:28
*/
@Transactional
public interface RoleService extends IService<Role> {

}

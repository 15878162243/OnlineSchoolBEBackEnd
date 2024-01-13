package com.example.onlineschoolbebackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.onlineschoolbebackend.entity.Role;
import com.example.onlineschoolbebackend.service.RoleService;
import com.example.onlineschoolbebackend.mapper.RoleMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
* @author mayn
* @description 针对表【role】的数据库操作Service实现
* @createDate 2024-01-10 17:17:28
*/
@Service
@Transactional
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}





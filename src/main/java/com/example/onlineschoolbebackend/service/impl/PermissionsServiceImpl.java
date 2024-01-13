package com.example.onlineschoolbebackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.onlineschoolbebackend.entity.Permissions;
import com.example.onlineschoolbebackend.service.PermissionsService;
import com.example.onlineschoolbebackend.mapper.PermissionsMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
* @author mayn
* @description 针对表【permissions】的数据库操作Service实现
* @createDate 2024-01-10 17:17:39
*/
@Service
@Transactional
public class PermissionsServiceImpl extends ServiceImpl<PermissionsMapper, Permissions>
    implements PermissionsService{

}





package com.example.onlineschoolbebackend.service;

import com.example.onlineschoolbebackend.entity.Permissions;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.transaction.Transactional;

/**
* @author mayn
* @description 针对表【permissions】的数据库操作Service
* @createDate 2024-01-10 17:17:39
*/
@Transactional
public interface PermissionsService extends IService<Permissions> {

}

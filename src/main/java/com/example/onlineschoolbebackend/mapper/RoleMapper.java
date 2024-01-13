package com.example.onlineschoolbebackend.mapper;

import com.example.onlineschoolbebackend.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.onlineschoolbebackend.utils.MybatisRedisCache;
import org.apache.ibatis.annotations.CacheNamespace;
import org.springframework.stereotype.Service;

/**
* @author mayn
* @description 针对表【role】的数据库操作Mapper
* @createDate 2024-01-10 17:17:28
* @Entity com.example.onlineschoolbebackend.entity.Role
*/
@Service
@CacheNamespace(implementation= MybatisRedisCache.class,eviction= MybatisRedisCache.class)
public interface RoleMapper extends BaseMapper<Role> {

}





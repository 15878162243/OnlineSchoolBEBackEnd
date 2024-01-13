package com.example.onlineschoolbebackend.mapper;

import com.example.onlineschoolbebackend.entity.Permissions;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.onlineschoolbebackend.utils.MybatisRedisCache;
import org.apache.ibatis.annotations.CacheNamespace;
import org.springframework.stereotype.Service;

/**
* @author mayn
* @description 针对表【permissions】的数据库操作Mapper
* @createDate 2024-01-10 17:17:39
* @Entity com.example.onlineschoolbebackend.entity.Permissions
*/
@Service
@CacheNamespace(implementation= MybatisRedisCache.class,eviction= MybatisRedisCache.class)
public interface PermissionsMapper extends BaseMapper<Permissions> {

}





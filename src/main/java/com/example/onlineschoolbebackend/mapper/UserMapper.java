package com.example.onlineschoolbebackend.mapper;

import com.example.onlineschoolbebackend.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.onlineschoolbebackend.utils.MybatisRedisCache;
import org.apache.ibatis.annotations.CacheNamespace;
import org.springframework.stereotype.Service;

/**
* @author mayn
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-12-13 18:40:08
* @Entity com.example.onlineschoolbebackend.entity.User
*/
@Service
@CacheNamespace(implementation= MybatisRedisCache.class,eviction= MybatisRedisCache.class) // redis 缓存
public interface UserMapper extends BaseMapper<User> {

}





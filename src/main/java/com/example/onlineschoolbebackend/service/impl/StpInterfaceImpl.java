package com.example.onlineschoolbebackend.service.impl;

import cn.dev33.satoken.stp.StpInterface;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.onlineschoolbebackend.entity.Permissions;
import com.example.onlineschoolbebackend.entity.Role;
import com.example.onlineschoolbebackend.entity.User;
import com.example.onlineschoolbebackend.mapper.PermissionsMapper;
import com.example.onlineschoolbebackend.mapper.RoleMapper;
import com.example.onlineschoolbebackend.service.PermissionsService;
import com.example.onlineschoolbebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 自定义权限加载接口实现类
 */
@Component    // 保证此类被 SpringBoot 扫描，完成 Sa-Token 的自定义权限验证扩展
@Transactional
public class StpInterfaceImpl implements StpInterface {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionsMapper permissionsMapper;
    /**
     * 返回一个账号所拥有的权限码集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        // 通过id，查到用户角色，然后再查角色所包含的所有权限
        User user = userService.getById((Serializable) loginId);
        // 所有权限
        QueryWrapper<Permissions> permissionsSearch = new QueryWrapper<>();
        permissionsSearch.eq("rid",user.getRid());
        List<Permissions> list = permissionsMapper.selectList(permissionsSearch);
        // 筛选
        List<String> list1 = new ArrayList<String>();
        for (int i=0;i<list.size();i++){
            list1.add(list.get(i).getPname());
        }
        return list1;
    }

    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        // 通过id，查到用户角色，然后再查角色所包含的所有权限
        User user = userService.getById((Serializable) loginId);
        // 所有权限
        QueryWrapper<Role> roleSearch = new QueryWrapper<>();
        roleSearch.eq("rid",user.getRid());
        List<Role> list = roleMapper.selectList(roleSearch);
        // 筛选
        List<String> list1 = new ArrayList<String>();
        for (int i=0;i<list.size();i++){
            list1.add(list.get(i).getRname());
        }
        return list1;
    }

}

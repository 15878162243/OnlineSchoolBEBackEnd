package com.example.onlineschoolbebackend.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.onlineschoolbebackend.entity.User;
import com.example.onlineschoolbebackend.mapper.UserMapper;
import com.example.onlineschoolbebackend.result.JsonResult;
import com.example.onlineschoolbebackend.service.UserService;
import com.example.onlineschoolbebackend.utils.MybatisRedisCache;
import com.example.onlineschoolbebackend.utils.UuidUtils;
import com.example.onlineschoolbebackend.utils.SecretUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.*;

@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired  // uuid 生成一个8位的62进制数
    private UuidUtils uuidUtils;
    @Autowired  // AES 加密和解密
    private SecretUtil secretUtil;

    // 普通用户注册
    @PostMapping("register/addUser")
    public SaResult addUser(@RequestBody User user){
        // 查询该账号是否也存在。
        QueryWrapper<User> userSearch = new QueryWrapper<>();
        userSearch.eq("account",user.getAccount());
        User user1 = userService.getOne(userSearch);
        if(user1 != null){
            return SaResult.error("该账号已存在！");
        }else{
            user.setId(uuidUtils.getUuid("user"));  // getUuid 生成一个uuid, 传表名
            user.setPassword(secretUtil.encrypt(user.getPassword())); // 密码加密
            user.setRid(3);  // 普通用户角色
            user.setCreatetime(new Date());
            boolean loginState = userService.save(user);
            if (loginState) {
                // 注册成功后，直接登录StpUtil会话，参数填写要登录的账号id
                StpUtil.login(user.getId());
                Map<String, Object> data = new HashMap<>();
                data.put("data",user);
                data.put("token",StpUtil.getTokenInfo());
                // 然后返回用户信息和登录后的token信息
                return SaResult.data(data);
            } else {
                return SaResult.error("注册失败");
            }
        }
    }

    // 管理员给作者注册账户 管理员才能进入该方法
    @SaCheckRole("admin")
    @PostMapping("register/addAuthor")
    public SaResult addAuthor(@RequestBody User user){
        // 查询该账号是否也存在。
        QueryWrapper<User> userSearch = new QueryWrapper<>();
        userSearch.eq("account",user.getAccount());
        User user1 = userService.getOne(userSearch);
        if(user1 != null){
            return SaResult.error("该账号已存在！");
        }else{
            user.setId(uuidUtils.getUuid("user"));  // getUuid 生成一个uuid, 传表名
            user.setPassword(secretUtil.encrypt(user.getPassword())); // 密码加密
            user.setRid(2);  // 作者角色
            user.setCreatetime(new Date());
            boolean loginState = userService.save(user);
            if (loginState) {
                // 注册成功后，直接登录StpUtil会话，参数填写要登录的账号id
                StpUtil.login(user.getId());
                Map<String, Object> data = new HashMap<>();
                data.put("data",user);
                data.put("token",StpUtil.getTokenInfo());
                // 然后返回用户信息和登录后的token信息
                return SaResult.data(data);
            } else {
                return SaResult.error("注册失败");
            }
        }
    }

    // 删除用户
    @SaCheckRole("admin")
    @PostMapping("deleteUser")
    public SaResult deleteUser(@RequestBody User user){
        if(user.getId() != null){
            boolean deleteUserState = userService.removeById(user.getId());
            return deleteUserState ? SaResult.ok("删除成功") : SaResult.error("删除失败！");
        }else{
            return SaResult.error("请传输要删除的用户ID！");
        }
    }

    // 修改用户信息
    @PostMapping("updateUser")
    public SaResult updateUser(@RequestBody User user){
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",user.getId());
        // 防止传输账号密码权限
        user.setAccount(null);
        user.setPassword(null);
        user.setRid(null);

        int updateUserState = userMapper.update(user,updateWrapper);
        return updateUserState == 1 ? SaResult.ok("更新成功") : SaResult.error("更新失败！");
    }

    // 获取所有的用户信息
    @SaCheckLogin
    @GetMapping("selectUserList")
    public SaResult selectUserList(){
        List<User> userList = userMapper.selectList(null);
        return SaResult.data(userList);
    }

    // 查询token信息
    @GetMapping("tokenInfo")
    public SaResult tokenInfo() {
        return SaResult.data(StpUtil.getTokenInfo());
    }

    // 获取用户的所有权限
    @PostMapping("getPermissionList")
    public SaResult getPermissionList(@RequestBody Object id) {
        return SaResult.data(StpUtil.getPermissionList(id));
    }

    // 获取用户的角色
    @PostMapping("getRoleList")
    public SaResult getRoleList(@RequestBody Object id) {
        return SaResult.data(StpUtil.getRoleList(id));
    }

    @RequestMapping("getPermission")
    public SaResult getPermission(@RequestBody Object id) {
//        // 查询权限信息 ，如果当前会话未登录，会返回一个空集合
//        List<String> permissionList = StpUtil.getPermissionList(id);
//        System.out.println("当前登录账号拥有的所有权限：" + permissionList);
//
//        // 查询角色信息 ，如果当前会话未登录，会返回一个空集合
//        List<String> roleList = StpUtil.getRoleList(id);
//        System.out.println("当前登录账号拥有的所有角色：" + roleList);

        // 返回给前端
        return SaResult.ok()
                .set("roleList", StpUtil.getRoleList(id))
                .set("permissionList", StpUtil.getPermissionList(id));
    }


}

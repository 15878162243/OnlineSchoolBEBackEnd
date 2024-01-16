package com.example.onlineschoolbebackend.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.onlineschoolbebackend.entity.User;
import com.example.onlineschoolbebackend.service.UserService;
import com.example.onlineschoolbebackend.utils.SecretUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login/")
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired  // AES 加密和解密
    private SecretUtil secretUtil;

    // 登录
    @PostMapping("doLogin")
    public SaResult searchUser(@RequestBody User user){
        // 查询该账号是否也存在。
        QueryWrapper<User> userSearch = new QueryWrapper<>();
        user.setPassword(secretUtil.encrypt(user.getPassword())); // 密码加密
        userSearch.eq("account",user.getAccount());
        userSearch.eq("password",user.getPassword());
        User user1 = userService.getOne(userSearch);
        if(user1 != null){
            // 登录StpUtil会话，参数填写要登录的账号id,该方法利用了Cookie自动注入的特性，省略了手写返回token。
            StpUtil.login(user1.getId());
            Map<String, Object> data = new HashMap<>();
            data.put("data",user1);
            data.put("token",StpUtil.getTokenInfo());
            // 返回用户信息和登录后的token信息
            return SaResult.data(data);
        }
        return SaResult.error("账号或密码不正确。");
    }

    // 退出登录
    @SaCheckLogin  // 只有登录之后才能进入该方法。
    @GetMapping("logout")
    public SaResult logout(){
        StpUtil.logout();
        return SaResult.ok("退出成功！");
    }

    // 查询登录状态
    @GetMapping("isLogin")
    public SaResult isLogin() {
        return SaResult.data(StpUtil.isLogin());
    }

}



package com.example.onlineschoolbebackend.interceptor;

import cn.dev33.satoken.SaManager;
import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class globalInterceptor  implements WebMvcConfigurer {
    // 注册 Sa-Token 拦截器，打开注解式鉴权功能
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册 Sa-Token 拦截器，打开注解式鉴权功能
        String[] addPathPatterns = {"/**"};
        String[] excludePathPatterns={
           "/login","/registry"
        };
        registry.addInterceptor(new SaInterceptor())
                .addPathPatterns(addPathPatterns) // 拦截
                .excludePathPatterns(excludePathPatterns); // 排除;

//        System.out.println("------------------------------");
//        System.out.println(StpUtil.getPermissionList("teZh3MbA_user"));  阿达


//        SaManager.getLog().debug("----- 请求path={}  提交token={}", SaHolder.getRequest().getRequestPath(), StpUtil.getTokenValue());
//        // 获取指定 token 对应的账号id，如果未登录，则返回 null
//        SaManager.getLog().debug("----- 当前token 对应的账号id={}", StpUtil.getLoginIdByToken(StpUtil.getTokenValue()));
    }
    // 禁止cookie
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.addAllowedOrigin("*"); // 允许所有来源
        corsConfig.addAllowedMethod("*"); // 允许所有HTTP方法
        corsConfig.addAllowedHeader("*"); // 允许所有HTTP标头
        // 项目使用了 sa-token,并且是使用 token 前后端分离的方式，并不是使用 cookies传递用户token，所以要设置为false
        corsConfig.setAllowCredentials(false); // 允许携带身份信息（如Cookies）

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsFilter(source);
    }


}

package com.example.onlineschoolbebackend;

import cn.dev33.satoken.SaManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableCaching
@EnableTransactionManagement
@SpringBootApplication
@MapperScan("com.example.onlineschoolbebackend.mapper")
public class OnlineSchoolBeBackEndApplication {

    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(OnlineSchoolBeBackEndApplication.class, args);
        System.out.println("启动成功，Sa-Token 配置如下：" + SaManager.getConfig());


    }

}

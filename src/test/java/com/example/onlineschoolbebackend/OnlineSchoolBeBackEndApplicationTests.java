package com.example.onlineschoolbebackend;

import com.example.onlineschoolbebackend.entity.User;
import com.example.onlineschoolbebackend.mapper.UserMapper;
import com.example.onlineschoolbebackend.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
class OnlineSchoolBeBackEndApplicationTests {
    @Autowired
    private UserService userService;

    @Autowired
    UserMapper userMapper;

    @Test
    public void test1(){
        System.out.println(("----- selectAll method test1 ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.isTrue(5 == userList.size(), "");
        userList.forEach(System.out::println);
    }

    @Test
    public void test2(){
        System.out.println(("----- selectAll method test21 ------"));
        long count = userService.count(null);
        System.out.println("count = " + count);
    }


}

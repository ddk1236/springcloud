package com.fc.controller;


import com.fc.entity.UserEntity;
import com.fc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @author ddk
 * @date 2021/8/17
 */
@RestController
@RequestMapping("/provide")
public class ProviderController {

    @Autowired
    public UserService userService;

    @RequestMapping("/hello")
    public String provide(){
        System.out.println("服务提供者1----");
        return "服务提供者1-----";
    }
    @RequestMapping("/user")
    public List<UserEntity> getUser(){
        List<UserEntity> entityList = userService.getBaseMapper().selectList(null);

        System.out.println("服务提供者2");
        return entityList;
    }

    @RequestMapping("/setUser")
    public UserEntity setUser(@RequestParam("id") Long id,
                              @RequestParam("age") Integer age,
                              @RequestParam("name") String name){
        UserEntity entity = new UserEntity();
        entity.setId(id);
        entity.setName(name);
        entity.setAge(age);
        System.out.println("服务提供者2");
        return entity;
    }
}

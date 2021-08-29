package com.fc.controller;

import com.fc.entity.UserEntity;
import com.fc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ddk
 * @date 2021/8/17
 */
@RestController
public class ProviderController {

    @Autowired
    public UserService userService;

    @RequestMapping("/provide/hello")
    public String provide(){
        System.out.println("服务提供者2");
        return "服务提供者2-----------------";
    }

    @RequestMapping("/provide/user")
    public List<UserEntity> getUser(){
        List<UserEntity> entityList = userService.getBaseMapper().selectList(null);

        System.out.println("服务提供者2");
        return entityList;
    }
}

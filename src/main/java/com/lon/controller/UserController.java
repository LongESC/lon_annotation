package com.lon.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lon.annotation.TransTarget;
import com.lon.annotation.Translate;
import com.lon.comomon.Result;
import com.lon.entity.User;
import com.lon.mapper.UserMapper;
import com.lon.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @projectName: lon_annotation
 * @package: com.lon.controller
 * @className: UserController
 * @author: LONZT
 * @description: TODO
 * @date: 2023/6/26 8:58
 * @version: 1.0
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserController {

    final UserService userService;

    @RequestMapping("/hello")
    public String hello(){

        return "Hello World";
    }
    @Translate(target = TransTarget.RESULT)
    @RequestMapping("/findUsersByName")
    public Result<Object> findUsersByName(String name,Page page){

        Page<User> list=userService.findUsersByName(name, page);

        return Result.success(list);
    }

    @Translate(target = TransTarget.PARAMS)
    @RequestMapping("/saveUser")
    public Result<Object> Save(User user){

        System.out.println(user);

        return Result.success(true);
    }


}

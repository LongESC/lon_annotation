package com.lon.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lon.annotation.TransTarget;
import com.lon.annotation.Translate;
import com.lon.comomon.Result;
import com.lon.entity.User;
import com.lon.mapper.BaseMapper;
import com.lon.mapper.UserMapper;
import com.lon.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


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

    final BaseMapper baseMapper;

    @RequestMapping("/hello")
<<<<<<< HEAD
    public String hello(){
        baseMapper.updateZtl();
=======
    public String hello(HttpServletRequest request){

        System.out.println(request.getRequestURL());//得到请求URL地址
        System.out.println(request.getRequestURI());//得到请求的资源
        System.out.println(request.getQueryString());
        System.out.println(request.getRemoteAddr());//得到来访者IP
        System.out.println(request.getRemoteHost());
        //由于没有在dns上注册所以打印结果还是127.0.0.1,如果是百度访问这个程序，则打印www.baidu.com
        System.out.println(request.getRemotePort());//得到请求的资源
        System.out.println(request.getMethod());//得到请求的资源

>>>>>>> d5321c4 (git test)
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

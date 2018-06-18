package com.alex.controller;

import com.alex.dao.model.User;
import com.alex.service.UserService;
import io.shardingsphere.core.api.HintManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * Created by xiaodong.liu on 2018/6/15.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private static  Logger log= LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping(value="users/{id}",method = RequestMethod.GET)
    public User getUser(@PathVariable("id") Integer id ){
         log.info(" id {}",id);
         User user =userService.getUser(id);
         log.info("get user success {}",user.getName());
         return user;
    }
    @RequestMapping(value = "users",method = RequestMethod.GET)
    public User saveUser(){
        Random random=new Random();
        User user=new User();
        user.setName("zhang san"+random.nextInt(1000));
        user.setAge(random.nextInt(50)+1);
        user.setSex(new Integer(random.nextInt(1)));
        user=userService.createUser(user);
        log.info("create user success ,{}",user.getName());
        return user;
    }

    @RequestMapping(value = "raw",method = RequestMethod.GET)
    public User createUserReadAndWrite(){
        Random random=new Random();
        User user=new User();
        user.setName("zhang san"+random.nextInt(10000));
        user.setAge(random.nextInt(50)+1);
        user.setSex(new Integer(random.nextInt(1)));
        user=userService.createUserReadAndWrite(user,13);
        log.info("createUserReadAndWrite success ,{}",user.getName());
        return user;
    }


    @RequestMapping(value = "war",method = RequestMethod.GET)
    public User createUserWriteAndRead(){
        Random random=new Random();
        User user=new User();
        user.setName("zhang san"+random.nextInt(10000));
        user.setAge(random.nextInt(50)+1);
        user.setSex(new Integer(random.nextInt(1)));
        user=userService.createUserWriteAndRead(user);
        log.info("createUserWriteAndRead success ,{}",user.getName());
        return user;
    }



}

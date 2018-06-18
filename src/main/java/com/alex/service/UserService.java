package com.alex.service;

import com.alex.annotation.HintMaster;
import com.alex.controller.UserController;
import com.alex.dao.mapper.UserMapper;
import com.alex.dao.model.User;
import com.alex.dao.model.UserExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiaodong.liu on 2018/6/15.
 */
@Service
public class UserService {
    private static Logger log= LoggerFactory.getLogger(UserService.class);
    @Resource
    private UserMapper userMapper;
    public User getUser(Integer id){
         User user=userMapper.selectByPrimaryKey(id);
         return user;

    }

    @Transactional(rollbackFor = Exception.class)
    public User createUser(User user){
        userMapper.insert(user);
        UserExample example=new UserExample();
        example.or().andNameEqualTo(user.getName()).andAgeEqualTo(user.getAge()).andSexEqualTo(user.getSex());
        List<User> newUserList=userMapper.selectByExample(example);
        if(true){
           //throw new NullPointerException();
        }
        return newUserList.get(0);

    }
    @Transactional(rollbackFor = Exception.class)
    @HintMaster
    public User createUserReadAndWrite(User user,Integer id){
        log.info("0--->createUserReadAndWrite {}",user.getName());
        User user1=userMapper.selectByPrimaryKey(id);
        log.info("1--->query user {}-{}",user1.getId(),user1.getName());
        userMapper.insert(user);
        log.info("2--->insert user {}",user.getName());
        UserExample example=new UserExample();
        example.or().andNameEqualTo(user.getName()).andAgeEqualTo(user.getAge()).andSexEqualTo(user.getSex());
        List<User> newUserList=userMapper.selectByExample(example);
        log.info("3--->query new user {}-{}",newUserList.get(0).getId(),newUserList.get(0).getName());
        return newUserList.get(0);

    }

    @Transactional(rollbackFor = Exception.class)
    public User createUserWriteAndRead(User user){
        log.info("0--->createUserWriteAndRead {}",user.getName());
        userMapper.insert(user);
        log.info("1--->insert user {}",user.getName());
        UserExample example=new UserExample();
        example.or().andNameEqualTo(user.getName()).andAgeEqualTo(user.getAge()).andSexEqualTo(user.getSex());
        List<User> newUserList=userMapper.selectByExample(example);
        log.info("2--->query new user {}-{}",newUserList.get(0).getId(),newUserList.get(0).getName());
        return newUserList.get(0);

    }

}

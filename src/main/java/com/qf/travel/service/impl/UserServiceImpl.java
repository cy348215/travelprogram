package com.qf.travel.service.impl;

import com.qf.travel.mapper.UserMapper;
import com.qf.travel.pojo.User;
import com.qf.travel.pojo.UserR;
import com.qf.travel.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    /**
     * 根据用户名查用户信息
     * @param uname
     * @return
     */
    @Override
    public User findUserByUname(String uname) {
        System.out.println(uname);
        User userInfoByUname = userMapper.findUserInfoByUname(uname);
        System.out.println(userInfoByUname);
        return userInfoByUname;
    }
    /**
     * 通过已知输入的用户信息判断是否输入正确
     * @param user
     * @return
     */
    @Override
    public User findUser(User user) {
        System.out.println(user);
        User user1 = userMapper.findUser(user);
        return user1;
    }

    /**
     * 查询用户角色表
     * @return
     */
    @Override
    public UserR findUR(int uid) {
        UserR ur = userMapper.findUR(uid);
        return ur;
    }
}

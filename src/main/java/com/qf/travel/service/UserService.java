package com.qf.travel.service;

import com.qf.travel.pojo.User;
import com.qf.travel.pojo.UserR;

public interface UserService {
    /**
     * 根据用户名查用户信息
     * @param uname
     * @return
     */
    public User findUserByUname(String uname);

    /**
     * 通过已知输入的用户信息判断是否输入正确
     * @param user
     * @return
     */
    public User findUser(User user);
    /**
     * 查询用户角色表
     * @return
     */
    public UserR findUR(int uid);
}

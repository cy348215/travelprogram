package com.qf.travel.mapper;

import com.qf.travel.pojo.User;
import com.qf.travel.pojo.UserR;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface UserMapper {
    /**
     * 通过登录名查询用户信息
     * @param uname 登录名
     * @return
     */
    public User findUserInfoByUname(@Param("uname") String uname);
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

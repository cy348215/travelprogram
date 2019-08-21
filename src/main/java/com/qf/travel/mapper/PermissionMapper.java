package com.qf.travel.mapper;

import com.qf.travel.pojo.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PermissionMapper {
    /**
     * 根据用户名查询该用户已分配的权限集合
     * @param uname  登录名（用户名）
     * @return  Permission对象的集合
     */
    public List<Permission> findPermissionsByUname(@Param("uname") String uname);
}

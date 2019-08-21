package com.qf.travel.service;

import com.qf.travel.pojo.Permission;

import java.util.List;

public interface PermissionService {
    /**
     * 根据用户名查询该用户已分配的权限集合
     * @param uname  登录名（用户名）
     * @return  Permission对象的集合
     */
    public List<Permission> findPermissionByUname(String uname);
}

package com.qf.travel.service.impl;

import com.qf.travel.mapper.PermissionMapper;
import com.qf.travel.pojo.Permission;
import com.qf.travel.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Resource
    private PermissionMapper permissionMapper;
    /**
     * 根据用户名查询该用户已分配的权限集合
     * @param uname  登录名（用户名）
     * @return  Permission对象的集合
     */
    @Override
    public List<Permission> findPermissionByUname(String uname) {
        List<Permission> permissionsByUname = permissionMapper.findPermissionsByUname(uname);
        return permissionsByUname;
    }
}

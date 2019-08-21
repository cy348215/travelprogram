package com.qf.travel.pojo;

import lombok.Data;

@Data
public class Permission {
    private int pid;//权限id
    private String pname;//权限名
    private String mname;//菜单名
    private String mcode;//菜单编号
}

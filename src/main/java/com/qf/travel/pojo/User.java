package com.qf.travel.pojo;

import lombok.Data;

@Data
public class User {
    private int uid;//用户id
    private String uname;//用户名
    private String upwd;//用户密码
    private String email;//邮箱
    private String realname;//真实姓名
    private String tel;//电话号
    private String sex;//性别
    private String birth;//生日
    private String createtime;//创建时间

}

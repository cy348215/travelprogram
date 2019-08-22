package com.qf.travel.controller;

import com.qf.travel.pojo.User;
import com.qf.travel.pojo.UserR;
import com.qf.travel.service.UserService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    //登录页展示
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String showLogin(){
        return "login";
    }

    /**
     * 登录处理
     * @return
     */
    @RequestMapping(value = "/dealLogin")
    public String dealLogin(@RequestParam("uname")String uname,
                            @RequestParam("upwd")String upwd ,HttpServletRequest request) {
        try {
            System.out.println(uname);
            User User=userService.findUserByUname(uname);
            Subject subject = SecurityUtils.getSubject();//从安全管理器中获取主体对象
            UsernamePasswordToken token=new UsernamePasswordToken(uname,upwd); //构建令牌对象
            subject.login(token);
            System.out.println(token);
            if(subject.isAuthenticated()){//判断是否正确登录
                //用户信息与权限信息存储
                System.out.println("登陆成功");
                request.getSession().setAttribute("User",User);
                return "main";
            }
        }catch (AuthenticationException e){
            e.printStackTrace();
            System.out.println("登录失败");
        }
        return "login";
    }

    /**
     * 登录判断
     * @param uname
     * @param password
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login1",method = RequestMethod.POST)
    public int login1(@RequestParam("uname")String uname,
                      @RequestParam("upwd")String password, HttpServletRequest request) {
        User u = new User();
        u.setUname(uname);
        u.setUpwd(password);
        User b=userService.findUser(u);
        int a=0;
        if (b!=null) {
            UserR ur = userService.findUR(b.getUid());
            request.getSession().setAttribute("user", b);
            if(ur.getRid()!=1){
                a = 2;
            }else {
                a = 1;
            }

        }
        return a;
    }

    /**
     * 登录前台
     * @param uname
     * @param upwd
     * @param request
     * @return
     */
    @RequestMapping("memberSave")
    public Object memberSave(String uname,String upwd,HttpServletRequest request){
        User u=new User();
        u.setUname(uname);
        u.setUpwd(upwd);
        User b=userService.findUser(u);
        request.getSession().setAttribute("currentUser",b);
        return "member";

    }
    //权限不足时，响应的页面
    @RequestMapping("/unauth")
    public String showPermission(){
        return "unauth";
    }
    //用户注销时
    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();//用户登录（清除用户在shiro中的驻留信息）
        return "redirect:login";
    }
    //超级管理员有权访问的模块
    @RequiresPermissions(value = "")
    @RequestMapping("/main")
    public String main(){
        return "main";
    }
    //会员管理员用户访问的模块
    @RequiresPermissions(value = {"memManage"})
    @RequestMapping("/adminis")
    public String adminis(){
        return "adminis";
    }
    //订单管理员用户访问的模块
    @RequiresPermissions(value = {"ordManage"})
    @RequestMapping("/ordManage")
    public String ordManage(){
        return "ordManage";
    }
}

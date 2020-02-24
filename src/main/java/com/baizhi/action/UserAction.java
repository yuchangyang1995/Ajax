package com.baizhi.action;

import com.baizhi.entity.User;
import com.baizhi.service.UserServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserAction {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String register(){
        System.out.println("-----------");
        System.out.println(name);
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.show(name);
        System.out.println(user);
        //获取Response
        HttpServletResponse response = ServletActionContext.getResponse();
        //设置响应时的编码
        response.setCharacterEncoding("UTF-8");
        try {
            PrintWriter out = response.getWriter();
            //判断user是否为null
            if (user!=null){
                //说明已经注册过
                out.print("用户名已被注册不可用");
            }else {
                //说明尚未注册
                out.print("用户名尚未注册 可用");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }
}

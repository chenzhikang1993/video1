package com.qf.controller;

import com.qf.pojo.User;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/loginUser")
    @ResponseBody
    public String loginUser(User user, HttpServletRequest request){

        User user1 = userService.selectUserByEmailAndPassword(user);
        if (user1 != null){
            HttpSession session = request.getSession();
            session.setAttribute("userAccount",user1.getEmail());
            return "success";
        }
        return "filed";

    }

}

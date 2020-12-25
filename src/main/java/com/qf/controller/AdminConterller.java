package com.qf.controller;


import com.qf.pojo.Admin;
import com.qf.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
//茹东杰
@Controller
@RequestMapping("/admin")
public class AdminConterller {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/loginView")
    public String loginView() {

        return "behind/login";
    }
    //茹东杰
    @RequestMapping("/login")
    @ResponseBody
    public String login(Admin admin, HttpServletRequest request) {
        admin = adminService.selectAdmin(admin);
        if (null != admin) {
            HttpSession session = request.getSession();
            session.setAttribute("userName",admin.getUsername());
            return "success";
        } else {
            return "failed";
        }
    }
    //茹东杰
    @RequestMapping("/exit")
    public String exit(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("userName");
        return "redirect:loginView";
    }
}

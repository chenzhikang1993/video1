package com.qf.controller;



import com.qf.pojo.User;
import com.qf.service.UserService;
import com.qf.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.HashMap;

import static com.qf.utils.MailUtils.getValidateCode;

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
            session.setAttribute("user",user);
            session.setAttribute("userAccount",user1.getEmail());
            return "success";
        }
        return "filed";

    }
    @RequestMapping("/forgetPassword")
    public String forgetPassword() {

        return "before/forget_password";
    }

    @RequestMapping("/sendEmail")
    @ResponseBody
    public String sendEmail(String email, HttpSession session){
        User user = userService.findByemail(email);
        if (user==null){
            // model.addAttribute("date","hasNoUser");
            return "hasNoUser";

        }
        String code = getValidateCode(6);
        if (MailUtils.sendMail("1789390420@qq.com", "你好，这是一封测试邮件，无需回复。",
                "验证码是：" + code)){
            //model.addAttribute("date","success");
            System.out.println("与语言");
            session.setAttribute(email,code);
            return "success";

        }
        // session.setAttribute(email,code);
        return "success";





        //model.addAttribute("date","success");


    }
    @RequestMapping("/validateEmailCode")
    public String validateEmailCode(String email, String code, HttpSession session, Model model){
        System.out.println(code);
        System.out.println(email);
        String code1 = (String) session.getAttribute(email);
        System.out.println(code1);

        if (code.equals(code1)){
            System.out.println("tiititi");
            model.addAttribute("email",email);
            return "before/reset_password";
        }

        return null;

    }

    //重置密码
    @RequestMapping("/resetPassword")
    public String resetPassword(String email,String password){
        HashMap<String, String> map = new HashMap<>();
        map.put("email",email);
        map.put("password",password);
        Integer update = userService.updateByEmail(map);
        return null;
    }

    //我的资料
    @RequestMapping("/showMyProfile")
    public String showMyProfile(Model model,HttpSession session){
        //整合时从seeion中拿取email
       // String email = "123@qq.com";
        String email = (String) session.getAttribute("userAccount");
        //
        User user = userService.findByemail(email);
        model.addAttribute("user",user);
        return "before/my_profile";
    }
    //to修改资料
    @RequestMapping("/changeProfile")
    public String changeProfile(Model model,HttpSession session){
        //整合时从seeion中拿取email
       // String email = "123@qq.com";
        String email = (String) session.getAttribute("userAccount");
        User user = userService.findByemail(email);
        model.addAttribute("user",user);

        return "before/change_profile";
    }

    //修改资料
    @RequestMapping("/updateUser")
    public String updateUser(User user,HttpSession session){
        //整合时从seeion中拿取email
       // String email = "123@qq.com";
        String email = (String) session.getAttribute("userAccount");
        user.setEmail(email);

        System.out.println(user.getNickName());

        userService.updateByEmail2(user);
        return "forward:showMyProfile";

    }

    @RequestMapping("/tocourse")
    public String to(){

        return "before/course";
    }

    /**
     * 前台退出1
     * @param request
     * @return
     */
    @RequestMapping("loginOut")
    public String loginOut(HttpServletRequest request){

        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.removeAttribute("userAccount");

        return "index";

    }

    /**
     * 前台退出2
     * @param request
     * @return
     */
    @RequestMapping("loginOut2")
    public String loginOut2(HttpServletRequest request){

        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.removeAttribute("userAccount");

        return "index";

    }

    @RequestMapping("passwordSafe")
    public String passwordSafe(){
        return "before/password_safe";
    }

    /**
     * 修改密码-验证旧密码
     * @param password
     * @param request
     * @return
     */
    @RequestMapping("validatePassword")
    @ResponseBody
    public String validatePassword(String password,HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (password.equals(user.getPassword())){
            return "success";
        }
        return "false";
    }

    @RequestMapping("updatePassword")
    public String updatePassword(HttpServletRequest request , String newPassword){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        userService.updatePasswoedByEmail(user.getEmail(),newPassword);

        return "redirect:/user/showMyProfile";


    }


}

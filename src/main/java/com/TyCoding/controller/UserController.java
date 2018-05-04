package com.TyCoding.controller;

import com.TyCoding.pojo.User;
import com.TyCoding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户的控制层
 *
 * @author TyCoding
 * @date 18-4-7下午9:00
 */
@Controller
@RequestMapping("/user")
public class UserController {

    //注入service
    @Autowired
    private UserService userService;

    /**
     * 用户登录
     */
    @RequestMapping(value = "/login")
    public String login(User user, Model model) {
        if (user != null) {
            User userResult = userService.login(user.getUsername());
            if(userResult != null){
                if (userResult.getPassword().equals(user.getPassword())) {
                    //登录成功
                    return "page/page";
                } else {
                    model.addAttribute("message", "登录失败");
                    return "page/loginInfo";
                }
            }else{
                model.addAttribute("message","登录失败");
                return "page/loginInfo";
            }
        } else {
            model.addAttribute("message", "你输入的信息为空");
            return "page/loginInfo";
        }
    }

    /**
     * 回到登录页
     */
    @RequestMapping(value="/index")
    public String index(){
        return "index";
    }
}

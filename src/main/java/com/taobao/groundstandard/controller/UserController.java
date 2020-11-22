/**
 * @program: ground-standard
 * @description:
 * @author: jojo
 * @create: 2020-06-09 21:19
 **/

package com.taobao.groundstandard.controller;

import com.taobao.groundstandard.entities.User;
import com.taobao.groundstandard.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    //    a为摊位id
    @GetMapping(value = "/user/tologin")
    public String login(@RequestParam("a") String a, HttpSession session) {
        session.setAttribute("a", a);
        return "redirect:/user/login";
    }

    @GetMapping(value = "/user/userinfo")
    public String userInfo(@RequestParam("loginId") Long loginId,
                           @RequestParam("Password") String passWord, HttpSession session) {
        String pass = userService.getPass(loginId);
        if (pass.equals(passWord)){
            session.setAttribute("loginId", loginId);
            User user = userService.findById(loginId);
            session.setAttribute("user", user);
            Object a = session.getAttribute("a");
            return "redirect:/user/stallinfo?a=" + a;
        }else {
            return "redirect:/user/login";
        }
    }

    @PostMapping(value = "/user/judge")
    public String judge(@RequestParam("stallId") String stallId,
                        HttpSession session) {
        Long loginId = (Long) session.getAttribute("loginId");
        if (userService.judge(loginId) < 70) {
//            session.setAttribute("msg", "信誉分不足，无法预约");
            return "redirect:/user/stallinfo?a=" + stallId + "&b="+true;
        }
        return "forward:/user/insertdata";
    }

    @PostMapping(value = "/user/regists")
    public String success(User user){
        userService.success(user);
        return "redirect:/user/login";
    }
}

/**
 * @program: ground-standard
 * @description:
 * @author: jojo
 * @create: 2020-06-09 21:22
 **/

package com.taobao.groundstandard.controller;

import com.taobao.groundstandard.entities.Stall;
import com.taobao.groundstandard.services.StallService;
import com.taobao.groundstandard.utils.DateFormat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

@Controller
@Slf4j
public class StallController {

    @Resource
    private StallService stallService;

    @GetMapping(value = "/user/stallinfo")
    public String stallInfo(@RequestParam("a") String stallId,
                            @RequestParam(value = "b",required = false) Boolean error,
                            HttpSession session, Model model) {
        session.getAttribute("user");
        Stall stallInfo = stallService.findStallInfo(stallId);
        model.addAttribute("stall", stallInfo);
        Date now_time = new Date();
        Date find_time = stallService.findETime(stallId);
        if (find_time != null) {
            boolean status = new DateFormat().dateStatus(now_time, find_time);
            model.addAttribute("status", status);
            if (status == false) {
                Long uId = stallService.findUId(stallId);
                Date time = stallService.findETime(stallId);
                model.addAttribute("uid", uId);
                model.addAttribute("time",time);
            }
        } else {
            model.addAttribute("status", true);
        }
        System.out.println(2222);
        System.out.println(error);
        if (error != null){
            System.out.println(error);
            if (error){
                model.addAttribute("msg", "信誉分不足，无法预约");
            }
        }
        return "index";
    }

    @PostMapping(value = "/user/insertdata")
    public String updateStatus(@RequestParam("stallId") String stallId, HttpSession session) {
        Long loginId = (Long) session.getAttribute("loginId");
        Date start_time = new Date();
        Date find_time = stallService.findETime(stallId);
        if (find_time != null) {
            boolean status = new DateFormat().dateStatus(start_time, find_time);
            if (status) {
                Date end_time = new DateFormat().getDate(start_time);
                stallService.insertData(loginId, stallId, start_time, end_time);
                return "redirect:/user/stallinfo?a=" + stallId;
            } else {
                session.setAttribute("msg", "被人抢先一步了");
                return "redirect:/user/stallinfo?a=" + stallId;
            }
        } else {
            Date end_time = new DateFormat().getDate(start_time);
            stallService.insertData(loginId, stallId, start_time, end_time);
            return "redirect:/user/stallinfo?a=" + stallId;
        }
    }

    @PostMapping(value = "/user/updatedate")
    public String updateDate(@RequestParam("stallId") String stallId) {
        Date end_time = new Date();
        stallService.updateDate(stallId, end_time);
        return "redirect:/user/stallinfo?a=" + stallId;
    }
}

/**
 * @program: ground-standard
 * @description:
 * @author: jojo
 * @create: 2020-06-09 21:21
 **/

package com.taobao.groundstandard.controller;

import com.taobao.groundstandard.entities.Intermediate;
import com.taobao.groundstandard.entities.Stall;
import com.taobao.groundstandard.services.ManagerService;
import com.taobao.groundstandard.utils.Zxing;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@Slf4j
public class ManagerController {

    @Resource
    private ManagerService managerService;

    @GetMapping(value = "/manager/managerinfo")
    public String managerInfo(@RequestParam("loginId") Long loginId,
                              HttpSession session){
        session.setAttribute("loginId",loginId);
        List<Stall> stalls = managerService.stallInfo(loginId);
        session.setAttribute("stalls",stalls);
        return "redirect:/manager/stall/list";
    }

    @GetMapping(value = "/manager/useinfo")
    public String useInfo(@RequestParam("loginId") Long loginId,
                              HttpSession session){
        List<Intermediate> uses = managerService.useInfo(loginId);
        session.setAttribute("uses",uses);
        return "redirect:/manager/uselist";
    }

    @PostMapping(value = "/manager/updateinfo")
    public String updateInfo(@RequestParam("integral") Integer integral,
                             @RequestParam("userId") Long useId,
                             @RequestParam("startTime") Date startTime, HttpSession session){
        Long loginId = (Long) session.getAttribute("loginId");
        managerService.updateInfo(integral,useId);
        managerService.updateStatus(startTime,useId);
        return "redirect:/manager/useinfo?loginId="+loginId;
    }

    @PostMapping(value = "/manager/addstall")
    public String addStall(Stall stall,HttpSession session){
        Long loginId = (Long) session.getAttribute("loginId");
        String manage = managerService.findManage(loginId);
        String stallId = manage+"-"+stall.getId();
        new Zxing().getphoto(stallId);
        stall.setId(stallId);
        managerService.insertStall(stall);
        return "redirect:/manager/managerinfo?loginId="+loginId;
    }

    @GetMapping(value = "/manager/update")
    public String updateStall(@RequestParam("stallId") String stallId,Model model,HttpSession session){
        Stall stall = managerService.findStall(stallId);
        model.addAttribute("stall",stall);
        return "forward:/manager/add";
    }

    @PutMapping(value = "/manager/addstall")
    public String updateStall(Stall stall,HttpSession session){
        Long loginId = (Long) session.getAttribute("loginId");
        managerService.updateStall(stall);
        return "redirect:/manager/managerinfo?loginId="+loginId;
    }

    @DeleteMapping(value = "/manager/deletestall")
    public String deleteStall(@Param("stallId") String stallId,HttpSession session){
        Long loginId = (Long) session.getAttribute("loginId");
        managerService.deleteStall(stallId);
        return "redirect:/manager/managerinfo?loginId="+loginId;
    }
}
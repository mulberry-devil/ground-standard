/**
 * @program: ground-standard
 * @description:
 * @author: jojo
 * @create: 2020-06-12 09:40
 **/

package com.taobao.groundstandard.component;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManagerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginId = request.getSession().getAttribute("loginId");
        if (loginId==null){
            request.setAttribute("msg", "请登录");
            request.getRequestDispatcher("/manager/login").forward(request, response);
            return false;
        }
        return true;
    }
}

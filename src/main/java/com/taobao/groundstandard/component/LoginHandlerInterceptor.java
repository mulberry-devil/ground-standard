/**
 * @program: ground-standard
 * @description:
 * @author: jojo
 * @create: 2020-06-10 06:15
 **/

package com.taobao.groundstandard.component;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object a = request.getSession().getAttribute("a");
        Object loginId = request.getSession().getAttribute("loginId");
        if (a == null) {
            request.setAttribute("msg", "请通过扫描二维码进行预约");
            request.getRequestDispatcher("/error").forward(request, response);
            return false;
        }
        if (loginId == null) {
            request.setAttribute("msg", "请登录");
            request.getRequestDispatcher("/user/login").forward(request, response);
            return false;
        }
        return true;
    }
}

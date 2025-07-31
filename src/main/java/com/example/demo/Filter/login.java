package com.example.demo.Filter;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.Control.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebFilter("/*")  // 拦截所有请求
@Component
public class login implements Filter {
    @Autowired
    private JWT jwt;  // 注入你写的 JWT 工具类
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURL().toString();
        // 放行登录接口
        if (url.contains("login")) {
            filterChain.doFilter(request, response);
            return;
        }
        // 获取 token
        String token = request.getHeader("token");
       /* Cookie []c=request.getCookies();
        for(Cookie co:c){
            co.getName().equals("");
        }*/
        // 检查 token 是否存在且合法
        if (!StringUtils.hasLength(token) || !jwt.encode(token)) {
            Result r = new Result(0, "error", "not login or token expired");
            String s = JSONObject.toJSONString(r);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(s);
            return; // 非法 token，终止请求
        }
        // 放行合法请求
        filterChain.doFilter(request, response);
    }
}

package com.example.demo.Filter;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.Control.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component

public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private JWT jwt;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        String url = request.getRequestURL().toString();
        // 登录接口放行
        if (url.contains("login")) {
            return true;
        }
        String token = request.getHeader("token");

        if (!StringUtils.hasLength(token) || !jwt.encode(token)) {
            Result r = new Result(0, "error", "not login or token expired");
            String s = JSONObject.toJSONString(r);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(s);
            System.out.println("not token or expire");
            return false; // 拦截请求
        }

        return true; // 放行请求
    }
}

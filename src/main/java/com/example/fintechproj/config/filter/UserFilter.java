package com.example.fintechproj.config.filter;

import com.example.common.UserVo;
import com.example.config.JwtAuthenticationProvider;
import com.example.fintechproj.service.UserService;
import lombok.RequiredArgsConstructor;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/user/*")
@RequiredArgsConstructor
public class UserFilter implements Filter {
    private JwtAuthenticationProvider jwtAuthenticationProvider;
    private UserService userService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String token = req.getHeader("X-AUTH_TOKEN");
        if(!jwtAuthenticationProvider.validateToken(token)){
            throw new ServletException("Invalid Access");
        }
        UserVo vo = jwtAuthenticationProvider.getUserVo(token);
        userService.findByUserIdAndUserEmail(vo.getUserId(),vo.getUserEmail()).orElseThrow(
                ()->new ServletException("Invalid Error")
        );

        chain.doFilter(request,response);
    }
}

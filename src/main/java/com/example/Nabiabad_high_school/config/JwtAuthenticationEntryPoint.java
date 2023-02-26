package com.example.Nabiabad_high_school.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {

        final String expired = (String) httpServletRequest.getAttribute("expired");
        System.out.println(expired);
        if (expired!=null){
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED,expired);
        }else{
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Invalid Login details");
        }
    }
}

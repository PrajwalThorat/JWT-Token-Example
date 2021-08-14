package com.stackroute.cartservice.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        String authHeader = request.getHeader("Authorization");
        if (request.getMethod().equals("OPTIONS")){
            response.setStatus(HttpServletResponse.SC_OK);
            chain.doFilter(request,response);
        }else if (authHeader == null || !authHeader.startsWith("Bearer ")){
            throw new ServletException("Missing Invalid Token");
        }
        String token = authHeader.substring(7);  // we have got the token
//       Validate the token
        Claims claims = Jwts.parser().setSigningKey("secretKey").parseClaimsJwt(token).getBody();

        request.setAttribute("claim" , claims);
        chain.doFilter(request,response);
    }
}

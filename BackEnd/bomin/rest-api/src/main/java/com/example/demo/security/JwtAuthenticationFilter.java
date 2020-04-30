package com.example.demo.security;

import com.example.demo.config.JwtTokenProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static com.sun.tools.doclint.Entity.amp;

public class JwtAuthenticationFilter extends GenericFilterBean {
    //Jwt가 유요한 토큰인지 인증하기 위한 Filter.
    //security 설정시 UsernamePasswordAuthenticationFilter앞에 세팅
    private JwtTokenProvider jwtTokenProvider;

    //Jwt Provider 주입
    public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider){
        this.jwtTokenProvider=jwtTokenProvider;
    }

    //Request로 들어오는 Jwt Token의 유효성을 검증(jwtTokenProvider.validateToken)하는
    //filter를 filterchain에 등록
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String token = jwtTokenProvider.resolveToken((HttpServletRequest)request);
        if(token != null &&  jwtTokenProvider.validateToken(token)){
            Authentication auth=jwtTokenProvider.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        filterChain.doFilter(request, response);
    }
}

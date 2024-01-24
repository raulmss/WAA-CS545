package edu.miu.springsecurity1.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class SomeFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("BEFORE THE FILTER CHAIN");
        filterChain.doFilter(servletRequest,servletResponse);

    }
}

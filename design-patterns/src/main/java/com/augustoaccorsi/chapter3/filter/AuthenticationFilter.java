package com.augustoaccorsi.chapter3.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "authentication", urlPatterns = "/admins/*", servletNames = "AdminRequestHandler")
public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;

        if(httpRequest.getSession().getAttribute("USER_TYPE").equals("ADMIN")){
            filterChain.doFilter(httpRequest, servletResponse);
        }
        else{
            ((HttpServletResponse) servletResponse).sendRedirect("/admin-login.html");
        }

    }
}

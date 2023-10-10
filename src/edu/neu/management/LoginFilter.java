package edu.neu.management;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter( "/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        if(request.getSession().getAttribute("username") != null
                || request.getRequestURI().endsWith("login")
                || request.getRequestURI().endsWith("Login.html")) {
            chain.doFilter(req, resp);
        }else {
            HttpServletResponse response = (HttpServletResponse)resp;
            response.sendRedirect("Login.html");
            System.out.println("666");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

package edu.neu.management;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class PremssionFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        if (
                request.getSession() != null
                        && request.getSession().getAttribute("identity") != null
                        && request.getSession().getAttribute("identity").equals("student")
        ) {
            if (request.getRequestURI().endsWith("lessonadd")
                    || request.getRequestURI().endsWith("lessondel")
                    || request.getRequestURI().endsWith("check") || request.getRequestURI().endsWith("lessonadd.jsp")
                    || request.getRequestURI().endsWith("conform") || request.getRequestURI().endsWith("studentlesson")
                    || request.getRequestURI().endsWith("studentlesson.jsp") || request.getRequestURI().endsWith("lessonlistbyname") || request.getRequestURI().endsWith("lessonupdate")
                    || request.getRequestURI().endsWith("selectbylessonname") || request.getRequestURI().endsWith("selectbylessonname1.jsp")
                    || request.getRequestURI().endsWith("lessonpage") || request.getRequestURI().endsWith("loginout")
                    || request.getRequestURI().endsWith("page")) {
                chain.doFilter(req, resp);
            } else {
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().print("<!DOCTYPE html><html lang='en'><head><meta charset='UTF-8'></head><body><h1 style='color:red'>你无权访问该功能！</h1><br/><a href='javascript:window.history.back()'>点击返回</a></body></html>");
            }


        } else if (

                request.getSession() != null
                        && request.getSession().getAttribute("identity") != null
                        && request.getSession().getAttribute("identity").equals("teacher")


        ) {
            if (request.getRequestURI().endsWith("teacherlesson")
                    || request.getRequestURI().endsWith("teacher")
                    || request.getRequestURI().endsWith("lessonappoval.jsp")
                    || request.getRequestURI().endsWith("listfiles") || request.getRequestURI().endsWith("lessonpage")
                    || request.getRequestURI().endsWith("selectbylessonname") || request.getRequestURI().endsWith("selectbystudentname")
                    || request.getRequestURI().endsWith("selectbylessonname.jsp") || request.getRequestURI().endsWith("selectbystudent.jsp")
                    || request.getRequestURI().endsWith("namepage") || request.getRequestURI().endsWith("page") || request.getRequestURI().endsWith("loginout")
                    || request.getRequestURI().endsWith("lessonappoval")) {
                chain.doFilter(req, resp);
            } else {
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().print("<!DOCTYPE html><html lang='en'><head><meta charset='UTF-8'></head><body><h1 style='color:red'>你无权访问该功能！</h1><br/><a href='javascript:window.history.back()'>点击返回</a></body></html>");
            }

        } else if (
                request.getSession() != null
                        && request.getSession().getAttribute("identity") != null
                        && request.getSession().getAttribute("identity").equals("manager")
        ) {
            if (request.getRequestURI().endsWith("manager")
                    || request.getRequestURI().endsWith("managerlesson")
                    || request.getRequestURI().endsWith("lessonappoval.jsp")
                    || request.getRequestURI().endsWith("managerappoval.jsp")
                    || request.getRequestURI().endsWith("selectbylessonname")
                    || request.getRequestURI().endsWith("selectbystudentname")
                    || request.getRequestURI().endsWith("namepage")
                    || request.getRequestURI().endsWith("lessonpage")
                    || request.getRequestURI().endsWith("selectbysdudentname1.jsp")
                    || request.getRequestURI().endsWith("selectbylessonname2.jsp")
                    || request.getRequestURI().endsWith("page")
                    || request.getRequestURI().endsWith("loginout")
                    || request.getRequestURI().endsWith("managerappoval")) {
                chain.doFilter(req, resp);
            } else {
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().print("<!DOCTYPE html><html lang='en'><head><meta charset='UTF-8'></head><body><h1 style='color:red'>你无权访问该功能！</h1><br/><a href='javascript:window.history.back()'>点击返回</a></body></html>");
            }

        } else if (
                request.getSession() != null
                        && request.getSession().getAttribute("identity") != null
                        && request.getSession().getAttribute("identity").equals("administrators")
        ) {
            if (request.getRequestURI().endsWith("addlesson")
                    || request.getRequestURI().endsWith("alllesson")
                    || request.getRequestURI().endsWith("allpasslesson")
                    || request.getRequestURI().endsWith("lessonnamagement")
                    || request.getRequestURI().endsWith("lessondelbyadmins")
                    || request.getRequestURI().endsWith("lessonupdatebymins")
                    || request.getRequestURI().endsWith("userupdate")
                    || request.getRequestURI().endsWith("useradd")
                    || request.getRequestURI().endsWith("usermanagement")
                    || request.getRequestURI().endsWith("addlesson.jsp")
                    || request.getRequestURI().endsWith("administrators.jsp")
                    || request.getRequestURI().endsWith("loginout")|| request.getRequestURI().endsWith("alllesson.jsp")
                    || request.getRequestURI().endsWith("lessonmanagement.jsp")|| request.getRequestURI().endsWith("lessonupdatebyadmins.jsp")
                    || request.getRequestURI().endsWith("useradd.jsp")|| request.getRequestURI().endsWith("usermanagement.jsp")
                    || request.getRequestURI().endsWith("userupdate.jsp") || request.getRequestURI().endsWith("lessondel")
                    || request.getRequestURI().endsWith("userdel")
            ) {
                chain.doFilter(req, resp);
            } else {
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().print("<!DOCTYPE html><html lang='en'><head><meta charset='UTF-8'></head><body><h1 style='color:red'>你无权访问该功能！</h1><br/><a href='javascript:window.history.back()'>点击返回</a></body></html>");
            }
        } else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

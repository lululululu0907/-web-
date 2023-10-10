package edu.neu.management;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PageServlet" ,urlPatterns = "/page")
public class PageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String identity=request.getSession().getAttribute("identity").toString();
        if(identity.equals("student")) {
            int page = Integer.parseInt(request.getParameter("page"));
            if (page <= 0) {
                response.sendRedirect("studentlesson?page=1");
                return;
            } else {
                response.sendRedirect("studentlesson?page=" + page);
            }
        }
         else if(identity.equals("teacher")) {
            int page = Integer.parseInt(request.getParameter("page"));
            if (page <= 0) {
                response.sendRedirect("teacherlesson?page=1");
                return;
            } else {
                response.sendRedirect("teacherlesson?page=" + page);
            }
        }
        if(identity.equals("manager")) {
            int page = Integer.parseInt(request.getParameter("page"));
            if (page <= 0) {
                response.sendRedirect("managerlesson?page=1");
                return;
            } else {
                response.sendRedirect("managerlesson?page=" + page);
            }
        }

    }
}

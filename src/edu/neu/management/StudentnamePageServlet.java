package edu.neu.management;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentnamePageServlet",urlPatterns = {"/namepage"})
public class StudentnamePageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String identity=request.getSession().getAttribute("identity").toString();
        int page = Integer.parseInt(request.getParameter("page"));
        String a=request.getSession().getAttribute("student").toString();
        if(identity.equals("teacher")) {
            if (page <= 0) {
                response.sendRedirect("selectbystudentname?page=1&studentname="+a);
                return;
            } else {
                response.sendRedirect("selectbystudentname?page=" + page+"&studentname="+a);
            }
        }
        if(identity.equals("manager")) {
            if (page <= 0) {
                response.sendRedirect("selectbystudentname?page=1&studentname="+a);
                return;
            } else {
                response.sendRedirect("selectbystudentname?page=" + page+"&studentname="+a);
            }
        }


    }
}

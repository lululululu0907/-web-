package edu.neu.management;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LessonnamePageServlet",urlPatterns = {"/lessonpage"})
public class LessonnamePageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String identity=request.getSession().getAttribute("identity").toString();
        if(identity.equals("teacher")) {
            int page = Integer.parseInt(request.getParameter("page"));
            String a=request.getSession().getAttribute("l").toString();
            if (page <= 0) {
                response.sendRedirect("selectbylessonname?page=1&lessonname="+a);
                return;
            } else {
                response.sendRedirect("selectbylessonname?page=" + page+"&lessonname="+a);
            }
        }
        if(identity.equals("student")){
            int page = Integer.parseInt(request.getParameter("page"));
            String a=request.getSession().getAttribute("l").toString();
            if (page <= 0) {
                response.sendRedirect("selectbylessonname?page=1&lessonname="+a);
                return;
            } else {
                response.sendRedirect("selectbylessonname?page=" + page+"&lessonname="+a);
            }
        }
        if(identity.equals("manager")){
            int page = Integer.parseInt(request.getParameter("page"));
            String a=request.getSession().getAttribute("l").toString();
            if (page <= 0) {
                response.sendRedirect("selectbylessonname?page=1&lessonname="+a);
                return;
            } else {
                response.sendRedirect("selectbylessonname?page=" + page+"&lessonname="+a);
            }
        }


    }
}

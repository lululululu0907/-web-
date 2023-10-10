package edu.neu.management;


import edu.neu.management.bean.Lesson;
import edu.neu.management.utils.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListServlet",urlPatterns = {"/teacher"})
public class ListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String teachername=request.getSession().getAttribute("username").toString();
        List<Lesson> list = DB.queryTeacherLesson(teachername);
        request.setAttribute("list", list);
        request.getRequestDispatcher("teacher.jsp").forward(request, response);

    }
}

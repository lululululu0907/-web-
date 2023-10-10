package edu.neu.management;

import edu.neu.management.bean.Lessonmanage;
import edu.neu.management.utils.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LessonmanagementServlet",urlPatterns = {"/lessonnamagement"})
public class LessonmanagementServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Lessonmanage> list= DB.queryLesson_Name();
        request.setAttribute("list", list);
        request.getRequestDispatcher("lessonmanagement.jsp").forward(request, response);

    }
}

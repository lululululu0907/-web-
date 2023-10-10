package edu.neu.management;

import edu.neu.management.bean.Lesson;
import edu.neu.management.bean.Lessonmanage;
import edu.neu.management.utils.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddLessonServlet",urlPatterns = {"/addlesson"})
public class AddLessonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lessonname = request.getParameter("lessonname");
        String teacher=request.getParameter("teacher");
        String manager=request.getParameter("manager");
        Lessonmanage lessonmanage=new Lessonmanage();
        lessonmanage.setLessonname(lessonname);
        lessonmanage.setTeacher(teacher);
        lessonmanage.setManager(manager);
        DB.addlessons(lessonmanage);
        response.sendRedirect("lessonnamagement");
    }
}

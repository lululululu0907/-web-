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

@WebServlet(name = "LessonUpdateBYadminsServlet",urlPatterns = {"/lessonupdatebymins"})
    public class LessonUpdateBYadminsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String teacher=request.getParameter("teacher");
        String manager=request.getParameter("manager");
        String lessonname = request.getParameter("lessonname");
        Lessonmanage lessonmanage=new Lessonmanage();
       lessonmanage.setLessonname(lessonname);
       lessonmanage.setTeacher(teacher);
       lessonmanage.setManager(manager);
        DB.updateLessonbyadmins(lessonmanage);
        response.sendRedirect("lessonnamagement");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
    }
}

package edu.neu.management;

import edu.neu.management.bean.Lesson;
import edu.neu.management.utils.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LessonUpdateServlet",urlPatterns = {"/lessonupdate"})
public class LessonUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        String lessonname = request.getParameter("lessonname");
        Lesson lesson=new Lesson();
        lesson.setCode(code);
        lesson.setLessonname(lessonname);
        DB.updateLesson(lesson);
        response.sendRedirect("lessonlistbyname");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        String lessonname=request.getParameter("lessonname");
        Lesson lesson=new Lesson();
        lesson.setCode(code);
        lesson.setLessonname(lessonname);
        Lesson result = DB.queryByCode(lesson);
        request.setAttribute("lesson", result);
        request.getRequestDispatcher("lessonlistbyname").forward(request, response);

    }
}

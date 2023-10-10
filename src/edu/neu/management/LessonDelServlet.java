package edu.neu.management;

import edu.neu.management.bean.Lesson;
import edu.neu.management.bean.User;
import edu.neu.management.utils.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LessonDelServlet",urlPatterns = {"/lessondel"})
public class LessonDelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String identity=request.getSession().getAttribute("identity").toString();
        if(identity.equals("student")) {
            String code = request.getParameter("code");
            Lesson lesson = new Lesson();
            lesson.setCode(code);
            DB.deleteLesson(lesson);
            response.sendRedirect("lessonlistbyname");
        }
        else if(identity.equals("administrators")){
            String code = request.getParameter("code");
            Lesson lesson = new Lesson();
            lesson.setCode(code);
            DB.deleteLesson(lesson);
            response.sendRedirect("alllesson");

        }


    }
}

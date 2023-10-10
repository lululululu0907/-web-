package edu.neu.management;

import edu.neu.management.bean.Lesson;
import edu.neu.management.utils.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LessonAppovalServlet",urlPatterns = {"/lessonappoval"})
public class LessonAppovalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        String reason1=request.getParameter("reason1");
        String sdata = request.getParameter("sdata");
        Lesson lesson=new Lesson();
        lesson.setCode(code);
        lesson.setReason1(reason1);
        lesson.setSdata(sdata);
        DB.approval(lesson);
        response.sendRedirect("teacher");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        String sdata=request.getParameter("sdata");
        Lesson lesson=new Lesson();
        lesson.setCode(code);
        lesson.setLessonname(sdata);
        Lesson result = DB.queryByCode(lesson);
        request.setAttribute("lesson", result);
        request.getRequestDispatcher("teacher").forward(request, response);

    }
}

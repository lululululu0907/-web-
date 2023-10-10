package edu.neu.management;

import edu.neu.management.bean.Lesson;
import edu.neu.management.utils.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ConformServlet",urlPatterns = {"/conform"})
public class ConformServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Lesson lesson=new Lesson();
        lesson.setCode(code);

        if(DB.conformLesson(lesson))
        response.sendRedirect("lessonlistbyname");
        else
        response.getWriter().print("<script language='JavaScript' charset=UTF-8 type='application/javascript'>alert('正在审批中');window.location.href='lessonlistbyname'</script>");






    }
}

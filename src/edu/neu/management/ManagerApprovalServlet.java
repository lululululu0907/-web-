package edu.neu.management;

import edu.neu.management.bean.Lesson;
import edu.neu.management.utils.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ManagerApprovalServlet",urlPatterns = {"/managerappoval"})
public class ManagerApprovalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        String sdata2 = request.getParameter("sdata2");
        String reason2=request.getParameter("reason2");
        Lesson lesson=new Lesson();
        lesson.setCode(code);
        lesson.setSdata2(sdata2);
        lesson.setReason2(reason2);
        DB.approval2(lesson);
        response.sendRedirect("manager");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        String sdata2=request.getParameter("sdata2");
        Lesson lesson=new Lesson();
        lesson.setCode(code);
        //lesson.setLessonname(sdata2);
        Lesson result = DB.queryByCode(lesson);
        request.setAttribute("lesson", result);
        request.getRequestDispatcher("manager").forward(request, response);

    }
}

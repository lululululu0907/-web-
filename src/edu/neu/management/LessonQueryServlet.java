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

@WebServlet(name = "LessonQueryServlet",urlPatterns = {"/lessonlistbyname"})
public class LessonQueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String applicant=request.getSession().getAttribute("username").toString();//获取username
        List<Lesson> list= DB.queryByname(applicant);//将其作为参数传入函数中
        request.setAttribute("list", list);
        request.getRequestDispatcher("lessonlist.jsp").forward(request, response);//请求转发到lessonlist。jsp
    }
}

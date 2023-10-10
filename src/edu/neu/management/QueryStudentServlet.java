package edu.neu.management;

import edu.neu.management.bean.Lesson;
import edu.neu.management.utils.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "QueryStudentServlet",urlPatterns = {"/studentlesson"})
public class QueryStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = Integer.parseInt(request.getParameter("page"));
        String applicant=request.getSession().getAttribute("username").toString();//获取username
        List<List<Lesson>> list= DB.queryByAll(applicant);//将其作为参数传入函数中
        List<Lesson>lessons = new ArrayList<>();
        if(page<=list.size())
            lessons=list.get(page-1);
        else
            lessons = list.get(list.size()-1);
        request.setAttribute("list",lessons);
        request.setAttribute("page",page);
        request.setAttribute("totalPage", list.size());
        request.setAttribute("lessonname",null);
        request.setAttribute("namelist",DB.get_AllLesson());
        request.getRequestDispatcher("studentlesson.jsp").forward(request, response);

    }
}

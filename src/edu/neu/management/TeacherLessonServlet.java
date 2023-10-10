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
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "TeacherLessonServlet",urlPatterns = {"/teacherlesson"})
public class TeacherLessonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = Integer.parseInt(request.getParameter("page"));
        String teacher=request.getSession().getAttribute("username").toString();//获取username
        List<List<Lesson>> list= DB.teacherlesson(teacher);
        List<Lesson>lessons = new ArrayList<>();
        if(page<=list.size())
            lessons=list.get(page-1);
        else
            lessons = list.get(list.size()-1);
        request.setAttribute("list",lessons);
        request.setAttribute("namelist",DB.selectTeacherLesson(teacher));//获取该老师所有被授权的课
        request.setAttribute("page",page);
        request.setAttribute("totalPage", list.size());
        request.getRequestDispatcher("teacherlesson.jsp").forward(request, response);
    }
}

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

@WebServlet(name = "SelectByLessonNameServlet",urlPatterns = {"/selectbylessonname"})
public class SelectByLessonNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String identity=request.getSession().getAttribute("identity").toString();//获取身份
        int page = Integer.parseInt(request.getParameter("page"));
        if(identity.equals("teacher")){//身份判断
        String teacher=request.getSession().getAttribute("username").toString();//获取username
        String lessonname = request.getParameter("lessonname");
            request.getSession().setAttribute("l",lessonname);
        List<List<Lesson>> list= DB.Select_teacherlesson_byLessonName(lessonname,teacher);//将其作为参数传入函数中
        if(page<=list.size())
            request.setAttribute("list", list.get(page-1));
        else if(list.size()!=0)
            request.setAttribute("list", list.get(list.size()-1));
        request.setAttribute("page",page);
        request.setAttribute("totalPage", list.size());
        request.getRequestDispatcher("selectbylessonname.jsp").forward(request, response);

        }
        else if(identity.equals("student")){
            String student=request.getSession().getAttribute("username").toString();//获取username
            String lessonname = request.getParameter("lessonname");
            request.getSession().setAttribute("l",lessonname);
            List<List<Lesson>> list=DB.Select_studentlesson_byLessonName(lessonname,student);//将其作为参数传入函数中
            if(page<=list.size())
                request.setAttribute("list", list.get(page-1));
            else if(list.size()!=0)
                request.setAttribute("list", list.get(list.size()-1));
            request.setAttribute("page",page);
            request.setAttribute("totalPage", list.size());
            request.getRequestDispatcher("selectbylessonname1.jsp").forward(request, response);
        }
        else if(identity.equals("manager")){
            String manager=request.getSession().getAttribute("username").toString();//获取username
            String lessonname = request.getParameter("lessonname");
            request.getSession().setAttribute("l",lessonname);
            List<List<Lesson>> list=DB.Select_managerlesson_byLessonName(lessonname,manager);//将其作为参数传入函数中
            if(page<=list.size())
                request.setAttribute("list", list.get(page-1));
            else if(list.size()!=0)
                request.setAttribute("list", list.get(list.size()-1));
            request.setAttribute("page",page);
            request.setAttribute("totalPage", list.size());
            request.getRequestDispatcher("selectbylessonname2.jsp").forward(request, response);
        }


    }
}

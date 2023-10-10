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

@WebServlet(name = "SelectByStudentNameServlet",urlPatterns = {"/selectbystudentname"})
public class SelectByStudentNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String identity=request.getSession().getAttribute("identity").toString();
        if(identity.equals("teacher")){
            int page = Integer.parseInt(request.getParameter("page"));
            String teacher=request.getSession().getAttribute("username").toString();//获取username
            String sdutent=request.getParameter("studentname");
            request.getSession().setAttribute("student",sdutent);
            List<List<Lesson>> list= DB.Select_teacherlesson_byStudentName(sdutent,teacher);//将其作为参数传入函数中
            if(page<=list.size())
                request.setAttribute("list", list.get(page-1));
            else if(list.size()!=0)
                request.setAttribute("list", list.get(list.size()-1));
            request.setAttribute("page",page);
            request.setAttribute("totalPage", list.size());
            request.getRequestDispatcher("selectbystudent.jsp").forward(request, response);
        }
        if(identity.equals("manager")){
            int page = Integer.parseInt(request.getParameter("page"));
            String teacher=request.getSession().getAttribute("username").toString();//获取username
            String sdutent=request.getParameter("studentname");
            request.getSession().setAttribute("student",sdutent);
            List<List<Lesson>> list= DB.Select_managerlesson_byStudentName(sdutent,teacher);//将其作为参数传入函数中
            if(page<=list.size())
                request.setAttribute("list", list.get(page-1));
            else if(list.size()!=0)
                request.setAttribute("list", list.get(list.size()-1));
            request.setAttribute("page",page);
            request.setAttribute("totalPage", list.size());
            request.getRequestDispatcher("selectbystudent1.jsp").forward(request, response);
        }

    }
}

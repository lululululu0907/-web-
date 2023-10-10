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

@WebServlet(name = "ManagerServlet",urlPatterns = {"/manager"})
public class ManagerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Manager=request.getSession().getAttribute("username").toString();
        List<Lesson> list = DB.queryManagerLesson(Manager);
        request.setAttribute("list", list);
        request.getRequestDispatcher("manager.jsp").forward(request, response);
    }
}

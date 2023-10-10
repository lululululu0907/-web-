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
import java.util.List;

@WebServlet(name = "UserManagementServlet",urlPatterns = {"/usermanagement"})
public class UserManagementServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> list = DB.getAlluser();
        request.setAttribute("list", list);
        request.getRequestDispatcher("usermanagement.jsp").forward(request, response);


    }
}

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

@WebServlet(name = "UserAddServlet",urlPatterns = {"/useradd"})
public class UserAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String identity=request.getParameter("identity");
        String applicant=request.getSession().getAttribute("username").toString();
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setIdentity(identity);
        List<Lesson> list= DB.queryAll(applicant);
        DB.adduser(user);
        response.sendRedirect("usermanagement");

    }
}

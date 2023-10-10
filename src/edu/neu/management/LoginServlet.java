package edu.neu.management;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import edu.neu.management.bean.User;
import edu.neu.management.utils.DB;


@WebServlet(name = "LoginServlet",urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        String identity = DB.queryRole(user);
        if(identity==null)
            response.sendRedirect("error.html");
        else if(identity.equals("student")){
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("password",password);
            request.getSession().setAttribute("identity",identity);
            response.sendRedirect("lessonlistbyname");
        }else if(identity.equals("teacher")){
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("password",password);
            request.getSession().setAttribute("identity",identity);
            response.sendRedirect("teacher");
        }
        else if(identity.equals("manager")){
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("password",password);
            request.getSession().setAttribute("identity",identity);
            response.sendRedirect("manager");
        }
        else if(identity.equals("administrators")){
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("password",password);
            request.getSession().setAttribute("identity",identity);
            response.sendRedirect("administrators.jsp");
        }
        else {
            response.sendRedirect("error.html");
        }
    }
}

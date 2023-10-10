package edu.neu.management;

import edu.neu.management.bean.User;
import edu.neu.management.utils.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserupdateServlet",urlPatterns = {"/userupdate"})
public class UserupdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String identity=request.getParameter("identity");
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setIdentity(identity);
        DB.updateUser(user);
        response.sendRedirect("usermanagement");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}

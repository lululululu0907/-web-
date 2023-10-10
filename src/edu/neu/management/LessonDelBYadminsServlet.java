package edu.neu.management;

import edu.neu.management.bean.Lessonmanage;
import edu.neu.management.bean.User;
import edu.neu.management.utils.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LessonDelBYadminsServlet",urlPatterns = {"/lessondelbyadmins"})
public class LessonDelBYadminsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lessonname=request.getParameter("lessonname");
        Lessonmanage lessonmanage=new Lessonmanage();
        lessonmanage.setLessonname(lessonname);
        DB.deleteLessonBYadmin(lessonmanage);
        response.sendRedirect("lessonnamagement");
    }
}

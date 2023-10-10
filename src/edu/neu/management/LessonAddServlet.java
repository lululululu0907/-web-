package edu.neu.management;

import edu.neu.management.bean.Lesson;
import edu.neu.management.bean.Lessonmanage;
import edu.neu.management.utils.DB;
import edu.neu.management.utils.RandomNumber;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LessonAddServlet",urlPatterns = {"/lessonadd"})
public class LessonAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code=RandomNumber.generate();
        response.setContentType("text/html;charset=UTF-8");
        String lessonname = request.getParameter("lessonname");
        String applyreason=request.getParameter("applyreason");
        String applicant=request.getSession().getAttribute("username").toString();
        Lesson lesson = new Lesson();
        lesson.setCode(code);
        lesson.setApplicant(applicant);
        lesson.setLessonname(lessonname);
        lesson.setApplyreason(applyreason);//得到添加的这一条元组
        List<Lesson> list= DB.queryAll(applicant);
        for (Lesson l:list){
            if(lesson.getLessonname().equals(l.getLessonname())){
                response.getWriter().print("<script language='JavaScript' type='application/javascript'>alert('禁止重复申请课程');window.location.href='lessonadd.jsp'</script>");
                return;
            }
        }
        DB.addLesson(lesson);
        response.sendRedirect("lessonlistbyname");

    }
}

package edu.neu.management;

import edu.neu.management.bean.Lesson;
import edu.neu.management.utils.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CheckServlet",urlPatterns = {"/check"})
public class CheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        response.setContentType("text/html;charset=UTF-8");
        //System.out.println(code);
        Lesson lesson=new Lesson();
        lesson.setCode(code);
        Lesson result = DB.checkByCode(lesson);
        String sdate1=result.getSdata();
        String sdate2=result.getSdata2();
        if(sdate1==null){

            response.getWriter().print("<script language='JavaScript' charset=UTF-8 type='application/javascript'>alert('主讲教师审批中');window.location.href='lessonlistbyname'</script>");


        }
        else if(sdate1!=null&&sdate2==null){
            response.getWriter().print("<script language='JavaScript' type='application/javascript'>alert('主管教师审批中');window.location.href='lessonlistbyname'</script>");
        }
        else if(sdate1.equals("pass")&sdate2.equals("pass")){
            response.getWriter().print("<script language='JavaScript' type='application/javascript'>alert('审批通过');window.location.href='lessonlistbyname'</script>");
        }
        else{
            response.getWriter().print("<script language='JavaScript' type='application/javascript'>alert('审批失败');window.location.href='lessonlistbyname'</script>");
        }


    }
}

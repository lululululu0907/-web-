package edu.neu.management;

import edu.neu.management.bean.Lesson;
import edu.neu.management.utils.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

@WebServlet(name = "AllPasslessonServlet",urlPatterns = {"/allpasslesson"})
public class AllPasslessonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Lesson> list =DB.AllpassLsson();
        response.setHeader("content-disposition","attachment;filename="+ URLEncoder.encode("passlesson.txt","UTF-8"));
        OutputStream outputStream=response.getOutputStream();
        for (Lesson lesson:list){
            outputStream.write(("代码 "+lesson.getCode()+"课程名 "+lesson.getLessonname()+"申请人"+lesson.getApplicant()+"\n").getBytes());
        }
        outputStream.close();


    }
}

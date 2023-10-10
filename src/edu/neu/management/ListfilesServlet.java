package edu.neu.management;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;

@WebServlet(name = "ListfilesServlet",urlPatterns = {"/listfiles"})
public class ListfilesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        File file=new File("d://upload");
        File[] files=file.listFiles();
        ArrayList<String> fileNames=new ArrayList<>();
        for(File f:files){
            fileNames.add(f.getName());
        }
        request.setAttribute("list",fileNames);
        request.getRequestDispatcher("filelist.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
    }
}

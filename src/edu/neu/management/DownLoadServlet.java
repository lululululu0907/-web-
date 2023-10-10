package edu.neu.management;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

@WebServlet("/download")
public class DownLoadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename=request.getParameter("filename");
        response.setHeader("content-disposition","attachment;filename="+ URLEncoder.encode(filename,"UTF-8"));
        FileInputStream fileInputStream=new FileInputStream("d://upload//"+filename);
        OutputStream outputStream=response.getOutputStream();
        byte[] buffer=new byte[1024];
        while (fileInputStream.read(buffer)>0){
            outputStream.write(buffer);
        }
        fileInputStream.close();
        outputStream.close();

    }
}

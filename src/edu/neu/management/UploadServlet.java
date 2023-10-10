package edu.neu.management;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "UploadServlet",urlPatterns = {"/upload"})
@MultipartConfig
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String applicant=request.getSession().getAttribute("username").toString();
        Part part=request.getPart("f1");
        String filename=part.getSubmittedFileName();
        String suffix=filename.substring(filename.lastIndexOf("."));
        part.write("d://upload//"+applicant +UUID.randomUUID().toString()+suffix);
        response.getWriter().print("<script language='JavaScript' type='application/javascript'>alert('success');window.location.href='lessonadd.jsp'</script>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

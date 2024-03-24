package org.example.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ConfigDemoServlet", urlPatterns = "/config",
        initParams = {
                @WebInitParam(name = "name1", value = "Chen Yuepan"),
                @WebInitParam(name = "studentid1", value = "2022211001000203")
        })
public class ConfigDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig config = getServletConfig();

        String yourName = config.getInitParameter("name");
        String studentId = config.getInitParameter("studentid");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Task 1-Get init parameters from web.xml</h2>");
        out.println("name: " + yourName + "<br>");
        out.println("student id: " + studentId);
        out.println("</body></html>");

        String name = config.getInitParameter("name1");
        String id1 = config.getInitParameter("studentid1");

        response.setContentType("text/html");
        out.println("<html><body>");
        out.println("<h2>Task 2-Get init parameters from @WebServlet</h2>");
        out.println("name: " + name + "<br>");
        out.println("student id: " + id1);
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

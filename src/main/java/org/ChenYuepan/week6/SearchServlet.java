package org.ChenYuepan.week6;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "/SearchServlet",value = "/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String txt = req.getParameter("txt");
        String search = req.getParameter("search");
        if(txt==null){
            resp.sendRedirect("index.jsp");
        }else {
            if("baidu".equals(search)){
                resp.sendRedirect("https://www.baidu.com/s?wd="+txt);
            } else if ("bing".equals(search)) {
                resp.sendRedirect("https://cn.bing.com/search?q="+txt);
            } else if ("google".equals(search)) {
                resp.sendRedirect("https://www.google.com/search?q="+txt);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

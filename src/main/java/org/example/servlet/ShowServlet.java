package org.example.servlet;

import org.example.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/show")
public class ShowServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("Email");
        String gender = req.getParameter("gender");

        String birth = req.getParameter("birth");
        //输出
        resp.getWriter().write("username："+username+"<br>"
                +"password："+password+"<br>"
                +"email: " + email+"<br>"
                +"gender："+gender+"<br>"
                +"birth："+birth);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

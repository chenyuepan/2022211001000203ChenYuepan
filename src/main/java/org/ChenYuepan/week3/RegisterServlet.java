package org.ChenYuepan.week3;

import org.example.utils.TimeUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.text.ParseException;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    private Connection connection;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        connection=(Connection) getServletContext().getAttribute("con");

//        String driver = getServletContext().getInitParameter("driver");
//        String url = getServletContext().getInitParameter("url");
//        String username = getServletContext().getInitParameter("Username");
//        String password = getServletContext().getInitParameter("Password");
//        try {
//            Class.forName(driver);
//            connection = DriverManager.getConnection(url, username, password);
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Insert a row into the database table "usertable"

        //设置编码
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("Email");
        String gender = request.getParameter("gender");

        String birth = request.getParameter("birth");

        int count=1;

        //使用预sql进行编译，解决sql注入问题
        try {
            PreparedStatement getCount = connection.prepareStatement("select * from usertable");
            ResultSet resultSet = getCount.executeQuery();
            while (resultSet.next()){
                count++;
            }

            PreparedStatement statement = connection.prepareStatement("insert into usertable(username,u_password,email,gender,birth) " +
                    "values (?,?,?,?,?)");
            statement.setString(1,username);
            statement.setString(2,password);
            statement.setString(3,email);
            statement.setString(4,gender);
            statement.setString(5,birth);
            int i = statement.executeUpdate();
            if(i==1){
                System.out.println("添加成功");
            }else {
                System.out.println("添加失败");
            }

            request.setAttribute("con",connection);
            response.sendRedirect("login.jsp");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        // Select all rows from "usertable"
//        try {
//            PreparedStatement statement = connection.prepareStatement("SELECT * FROM usertable");
//            ResultSet resultSet = statement.executeQuery();
//
//
//            response.setContentType("text/html");
//            PrintWriter out = response.getWriter();
//            out.println("<html><body>");
//            out.println("<table border='1'>" +
//                    "<tr>" +
//                    "<th>ID</th>" +
//                    "<th>UserName</th>" +
//                    "<th>Password</th>" +
//                    "<th>Email</th>" +
//                    "<th>Gender</th>" +
//                    "<th>Birthdate</th>" +
//                    "</tr>");
//            while (resultSet.next()) {
//                out.println("<tr><td>"
//                        + resultSet.getInt("id") + "</td><td>"
//                        + resultSet.getString("username") + "</td><td>"
//                        + resultSet.getString("u_password") + "</td><td>"
//                        + resultSet.getString("email") + "</td><td>"
//                        + resultSet.getString("gender") + "</td><td>"
//                        + resultSet.getString("birth")
//                        + "</td></tr>");
//            }
//            out.println("</table>");
//            out.println("</body></html>");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    public void destroy() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


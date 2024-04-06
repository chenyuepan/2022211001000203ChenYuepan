package org.ChenYuepan.week5;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "/LoginServlet",value = "/login")
public class LoginServlet extends HttpServlet {
    private Connection connection;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        String driver = getServletContext().getInitParameter("driver");
        String url = getServletContext().getInitParameter("url");
        String username = getServletContext().getInitParameter("Username");
        String password = getServletContext().getInitParameter("Password");
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Insert a row into the database table "usertable"

        //设置编码
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int count=1;

        //使用预sql进行编译，解决sql注入问题
        try {

            PreparedStatement getCount = connection.prepareStatement("select * from usertable where username= ? and u_password= ?");
            getCount.setString(1,username);
            getCount.setString(2,password);
            ResultSet resultSet = getCount.executeQuery();
            if (resultSet.next()){
                request.setAttribute("id",resultSet.getInt("id"));
                request.setAttribute("username",resultSet.getString("username"));
                request.setAttribute("password",resultSet.getString("u_password"));
                request.setAttribute("email",resultSet.getString("email"));
                request.setAttribute("gender",resultSet.getString("gender"));
                request.setAttribute("birthDate",resultSet.getString("birth"));

                request.getRequestDispatcher("/week5/userinfo.jsp").forward(request,response);
                count++;
            }else {
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("week5/login.jsp").forward(request,response);
            }
//            response.setContentType("text/html");
//            PrintWriter out = response.getWriter();
//            out.println("<html><body>");
//            if(count>1){
//                out.println("<h2>Login Success !!!</h2>");
//                out.println("Welcome， " + username + "<br>");
//            }else {
//                out.println("<h2>The user name or password is incorrect</h2>");
//            }
//            out.println("</body></html>");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

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

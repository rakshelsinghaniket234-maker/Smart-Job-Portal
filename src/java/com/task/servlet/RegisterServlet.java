package com.task.servlet;

import com.task.utility.ConnectionPool;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int userId = Integer.parseInt(
                    request.getParameter("user_id"));

            String name =
                    request.getParameter("name");

            String email =
                    request.getParameter("email");

            String password =
                    request.getParameter("password");

            String phone =
                    request.getParameter("phone");

            String role =
                    request.getParameter("role");

            String address =
                    request.getParameter("address");

            String resume =
                    request.getParameter("resume");


            Connection con =
                    ConnectionPool.connectDB();


            String sql =
                    "INSERT INTO users " +
                    "(user_id,name,email,password,phone,role,address,resume) " +
                    "VALUES(?,?,?,?,?,?,?,?)";


            PreparedStatement ps =
                    con.prepareStatement(sql);


            ps.setInt(1, userId);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setString(4, password);
            ps.setString(5, phone);
            ps.setString(6, role);
            ps.setString(7, address);
            ps.setString(8, resume);


            int result =
                    ps.executeUpdate();


            if (result > 0) {

                response.sendRedirect(
                        "login.jsp?msg=Registration Successful");

            } else {

                response.sendRedirect(
                        "register.jsp?error=Registration Failed");
            }


            ps.close();

        } catch (Exception e) {

            e.printStackTrace();

            response.sendRedirect("error.jsp");
        }
    }
}
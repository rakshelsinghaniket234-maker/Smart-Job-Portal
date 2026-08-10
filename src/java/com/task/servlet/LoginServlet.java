package com.task.servlet;

import com.task.utility.ConnectionPool;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        String email =
                request.getParameter("email");

        String password =
                request.getParameter("password");


        try {

            Connection con =
                    ConnectionPool.connectDB();


            String sql =
                    "SELECT * FROM users " +
                    "WHERE email=? AND password=?";


            PreparedStatement ps =
                    con.prepareStatement(sql);


            ps.setString(1, email);
            ps.setString(2, password);


            ResultSet rs =
                    ps.executeQuery();


            if (rs.next()) {

                // Session create
                HttpSession session =
                        request.getSession();


                // User information session mein save
                session.setAttribute(
                        "user_id",
                        rs.getInt("user_id")
                );


                session.setAttribute(
                        "user",
                        rs.getString("name")
                );


                session.setAttribute(
                        "email",
                        rs.getString("email")
                );


                session.setAttribute(
                        "role",
                        rs.getString("role")
                );


                // Dashboard
                response.sendRedirect(
                        "Dashboard.jsp"
                );

            } else {

                // Invalid login
                response.sendRedirect(
                        "login.jsp?error=Invalid Email or Password"
                );
            }


            rs.close();
            ps.close();


        } catch (Exception e) {

            e.printStackTrace();

            response.sendRedirect(
                    "error.jsp"
            );
        }
    }
}
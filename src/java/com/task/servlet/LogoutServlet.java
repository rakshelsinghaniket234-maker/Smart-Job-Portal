package com.task.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // Existing session ko get karo
        HttpSession session = request.getSession(false);

        // Agar session available hai
        if (session != null) {

            // Session destroy
            session.invalidate();
        }

        // Logout ke baad Home Page
        response.sendRedirect("index.jsp");
    }
}
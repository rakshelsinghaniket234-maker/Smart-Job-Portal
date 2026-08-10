package com.task.servlet;

import com.task.bean.ApplicationBean;
import com.task.dao.ApplicationDAO;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ApplyJobServlet")
public class ApplyJobServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        try {

            HttpSession session = request.getSession();

            // Check login
            Object userIdObject =
                    session.getAttribute("user_id");

            if (userIdObject == null) {

                response.sendRedirect("login.jsp");
                return;
            }

            int userId =
                    Integer.parseInt(
                            userIdObject.toString()
                    );

            // Get Job ID
            String jobIdString =
                    request.getParameter("job_id");

            if (jobIdString == null
                    || jobIdString.trim().equals("")) {

                out.println("<script>");
                out.println("alert('Job ID is missing');");
                out.println("window.location='ViewJobs.jsp';");
                out.println("</script>");

                return;
            }

            int jobId =
                    Integer.parseInt(jobIdString);

            // Create Bean
            ApplicationBean ab =
                    new ApplicationBean();

            ab.setUser_id(userId);
            ab.setJob_id(jobId);

            // DAO
            ApplicationDAO dao =
                    new ApplicationDAO();

            int result =
                    dao.applyJob(ab);

            if (result > 0) {

                out.println("<script>");
                out.println("alert('Job Applied Successfully');");
                out.println(
                        "window.location='ViewApplications.jsp';"
                );
                out.println("</script>");

            } else if (result == -1) {

                out.println("<script>");
                out.println(
                        "alert('You have already applied for this job');"
                );
                out.println("window.location='ViewJobs.jsp';");
                out.println("</script>");

            } else {

                out.println("<script>");
                out.println("alert('Job Application Failed');");
                out.println("window.location='ViewJobs.jsp';");
                out.println("</script>");
            }

        } catch (Exception e) {

            e.printStackTrace();

            out.println("<h3>Error: "
                    + e.getMessage()
                    + "</h3>");
        }
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }
}
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

@WebServlet("/UpdateJobServlet")
public class UpdateJobServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int jobId = Integer.parseInt(
                    request.getParameter("job_id"));

            String title =
                    request.getParameter("title");

            String description =
                    request.getParameter("description");

            String location =
                    request.getParameter("location");

            double salary = Double.parseDouble(
                    request.getParameter("salary"));

            String skills =
                    request.getParameter("skills");

            String jobType =
                    request.getParameter("job_type");


            Connection con =
                    ConnectionPool.connectDB();


            String sql =
                    "UPDATE jobs SET " +
                    "title=?, description=?, location=?, " +
                    "salary=?, skills=?, job_type=? " +
                    "WHERE job_id=?";


            PreparedStatement ps =
                    con.prepareStatement(sql);


            ps.setString(1, title);
            ps.setString(2, description);
            ps.setString(3, location);
            ps.setDouble(4, salary);
            ps.setString(5, skills);
            ps.setString(6, jobType);
            ps.setInt(7, jobId);


            int result =
                    ps.executeUpdate();


            if (result > 0) {

                response.sendRedirect(
                        "ViewJobs.jsp?msg=Job Updated Successfully");

            } else {

                response.sendRedirect(
                        "ViewJobs.jsp?error=Job Not Found");
            }


            ps.close();

        } catch (Exception e) {

            e.printStackTrace();

            response.sendRedirect("error.jsp");
        }
    }
}
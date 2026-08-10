package com.task.servlet;

import com.task.utility.ConnectionPool;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddJobServlet")
public class AddJobServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int jobId = Integer.parseInt(
                    request.getParameter("job_id"));

            int employerId = Integer.parseInt(
                    request.getParameter("employer_id"));

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

            Date postedDate =
                    Date.valueOf(
                    request.getParameter("posted_date"));


            Connection con =
                    ConnectionPool.connectDB();


            String sql =
                    "INSERT INTO jobs " +
                    "(job_id,employer_id,title,description,location," +
                    "salary,skills,job_type,posted_date) " +
                    "VALUES(?,?,?,?,?,?,?,?,?)";


            PreparedStatement ps =
                    con.prepareStatement(sql);


            ps.setInt(1, jobId);
            ps.setInt(2, employerId);
            ps.setString(3, title);
            ps.setString(4, description);
            ps.setString(5, location);
            ps.setDouble(6, salary);
            ps.setString(7, skills);
            ps.setString(8, jobType);
            ps.setDate(9, postedDate);


            int result =
                    ps.executeUpdate();


            if (result > 0) {

                response.sendRedirect(
                        "ViewJobs.jsp?msg=Job Added Successfully");

            } else {

                response.sendRedirect(
                        "AddJob.jsp?error=Job Not Added");
            }


            ps.close();

        } catch (Exception e) {

            e.printStackTrace();

            response.sendRedirect("error.jsp");
        }
    }
}
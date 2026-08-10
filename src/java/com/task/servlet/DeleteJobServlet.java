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

@WebServlet("/DeleteJobServlet")
public class DeleteJobServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int jobId = Integer.parseInt(
                    request.getParameter("job_id"));


            Connection con =
                    ConnectionPool.connectDB();


            String sql =
                    "DELETE FROM jobs WHERE job_id=?";


            PreparedStatement ps =
                    con.prepareStatement(sql);


            ps.setInt(1, jobId);


            int result =
                    ps.executeUpdate();


            if (result > 0) {

                response.sendRedirect(
                        "ViewJobs.jsp?msg=Job Deleted Successfully");

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
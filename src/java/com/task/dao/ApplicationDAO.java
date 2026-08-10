package com.task.dao;

import com.task.bean.ApplicationBean;
import com.task.utility.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ApplicationDAO {

    private Connection conn;

    public ApplicationDAO() {
        conn = ConnectionPool.connectDB();
    }

    // Apply Job
    public int applyJob(ApplicationBean ab) {

        int result = 0;

        try {

            // Check already applied
            String checkSql =
                    "SELECT application_id FROM application "
                    + "WHERE user_id=? AND job_id=?";

            PreparedStatement checkPs =
                    conn.prepareStatement(checkSql);

            checkPs.setInt(1, ab.getUser_id());
            checkPs.setInt(2, ab.getJob_id());

            ResultSet rs = checkPs.executeQuery();

            if (rs.next()) {

                return -1;
            }

            // Get next application ID
            String idSql =
                    "SELECT IFNULL(MAX(application_id),0)+1 "
                    + "FROM application";

            PreparedStatement idPs =
                    conn.prepareStatement(idSql);

            ResultSet idRs = idPs.executeQuery();

            int applicationId = 1;

            if (idRs.next()) {
                applicationId = idRs.getInt(1);
            }

            // Insert application
            String sql =
                    "INSERT INTO application "
                    + "(application_id,user_id,job_id,apply_date,status) "
                    + "VALUES(?,?,?,?,?)";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setInt(1, applicationId);
            ps.setInt(2, ab.getUser_id());
            ps.setInt(3, ab.getJob_id());
            ps.setDate(4,
                    new java.sql.Date(
                            System.currentTimeMillis()
                    )
            );
            ps.setString(5, "Applied");

            result = ps.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return result;
    }

    // View Applications
    public ArrayList<ApplicationBean> getApplicationsByUser(int userId) {

        ArrayList<ApplicationBean> list =
                new ArrayList<ApplicationBean>();

        try {

            String sql =
                    "SELECT application_id,user_id,job_id,"
                    + "apply_date,status "
                    + "FROM application "
                    + "WHERE user_id=?";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                ApplicationBean ab =
                        new ApplicationBean();

                ab.setApplication_id(
                        rs.getInt("application_id")
                );

                ab.setUser_id(
                        rs.getInt("user_id")
                );

                ab.setJob_id(
                        rs.getInt("job_id")
                );

                ab.setApply_date(
                        rs.getString("apply_date")
                );

                ab.setStatus(
                        rs.getString("status")
                );

                list.add(ab);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return list;
    }
}
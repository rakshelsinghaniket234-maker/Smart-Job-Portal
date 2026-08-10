package com.task.dao;

import com.task.bean.JobBean;
import com.task.utility.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobDAO {

    // Add new job (Employer)
    public boolean addJob(JobBean job) {
        String sql = "INSERT INTO jobs(job_id, employer_id, title, description, location, salary, skills, job_type, posted_date) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = ConnectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, job.getJobId());
            ps.setInt(2, job.getEmployerId());
            ps.setString(3, job.getTitle());
            ps.setString(4, job.getDescription());
            ps.setString(5, job.getLocation());
            ps.setDouble(6, job.getSalary());
            ps.setString(7, job.getSkills());
            ps.setString(8, job.getJobType());
            ps.setDate(9, job.getPostedDate());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Update existing job
    public boolean updateJob(JobBean job) {
        String sql = "UPDATE jobs SET title=?, description=?, location=?, salary=?, skills=?, job_type=? WHERE job_id=?";
        try (Connection con = ConnectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, job.getTitle());
            ps.setString(2, job.getDescription());
            ps.setString(3, job.getLocation());
            ps.setDouble(4, job.getSalary());
            ps.setString(5, job.getSkills());
            ps.setString(6, job.getJobType());
            ps.setInt(7, job.getJobId());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete job
    public boolean deleteJob(int jobId) {
        String sql = "DELETE FROM jobs WHERE job_id = ?";
        try (Connection con = ConnectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, jobId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get job by id
    public JobBean getJobById(int jobId) {
        String sql = "SELECT j.*, e.company_name FROM jobs j " +
                     "JOIN employers e ON j.employer_id = e.employer_id " +
                     "WHERE j.job_id = ?";
        try (Connection con = ConnectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, jobId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapRow(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Get all jobs (with company name via join)
    public List<JobBean> getAllJobs() {
        List<JobBean> list = new ArrayList<>();
        String sql = "SELECT j.*, e.company_name FROM jobs j " +
                     "JOIN employers e ON j.employer_id = e.employer_id " +
                     "ORDER BY j.posted_date DESC";
        try (Connection con = ConnectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(mapRow(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Search jobs by title, location or skills
    public List<JobBean> searchJobs(String keyword) {
        List<JobBean> list = new ArrayList<>();
        String sql = "SELECT j.*, e.company_name FROM jobs j " +
                     "JOIN employers e ON j.employer_id = e.employer_id " +
                     "WHERE j.title LIKE ? OR j.location LIKE ? OR j.skills LIKE ? " +
                     "ORDER BY j.posted_date DESC";
        try (Connection con = ConnectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            String likeKeyword = "%" + keyword + "%";
            ps.setString(1, likeKeyword);
            ps.setString(2, likeKeyword);
            ps.setString(3, likeKeyword);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapRow(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Get all jobs posted by a specific employer
    public List<JobBean> getJobsByEmployer(int employerId) {
        List<JobBean> list = new ArrayList<>();
        String sql = "SELECT j.*, e.company_name FROM jobs j " +
                     "JOIN employers e ON j.employer_id = e.employer_id " +
                     "WHERE j.employer_id = ?";
        try (Connection con = ConnectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, employerId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapRow(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    private JobBean mapRow(ResultSet rs) throws SQLException {
        JobBean j = new JobBean();
        j.setJobId(rs.getInt("job_id"));
        j.setEmployerId(rs.getInt("employer_id"));
        j.setTitle(rs.getString("title"));
        j.setDescription(rs.getString("description"));
        j.setLocation(rs.getString("location"));
        j.setSalary(rs.getDouble("salary"));
        j.setSkills(rs.getString("skills"));
        j.setJobType(rs.getString("job_type"));
        j.setPostedDate(rs.getDate("posted_date"));
        j.setCompanyName(rs.getString("company_name"));
        return j;
    }
}
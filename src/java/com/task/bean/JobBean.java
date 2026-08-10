package com.task.bean;

import java.sql.Date;

/**
 * Bean class for "jobs" table.
 * jobs(job_id, employer_id, title, description, location, salary,
 *      skills, job_type, posted_date)
 */
public class JobBean {

    private int jobId;
    private int employerId;
    private String title;
    private String description;
    private String location;
    private double salary;
    private String skills;
    private String jobType;
    private Date postedDate;

    // Extra field (not in DB) - handy for JSP display, filled by DAO joins
    private String companyName;

    public JobBean() {
    }

    public JobBean(int jobId, int employerId, String title, String description,
                    String location, double salary, String skills,
                    String jobType, Date postedDate) {
        this.jobId = jobId;
        this.employerId = employerId;
        this.title = title;
        this.description = description;
        this.location = location;
        this.salary = salary;
        this.skills = skills;
        this.jobType = jobType;
        this.postedDate = postedDate;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getEmployerId() {
        return employerId;
    }

    public void setEmployerId(int employerId) {
        this.employerId = employerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "JobBean{" +
                "jobId=" + jobId +
                ", employerId=" + employerId +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", salary=" + salary +
                ", skills='" + skills + '\'' +
                ", jobType='" + jobType + '\'' +
                ", postedDate=" + postedDate +
                '}';
    }
}

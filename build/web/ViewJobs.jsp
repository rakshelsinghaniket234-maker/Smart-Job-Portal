<%@page import="java.util.List"%>
<%@page import="com.task.bean.JobBean"%>
<%@page import="com.task.dao.JobDAO"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    List<JobBean> jobs = null;

    try {
        JobDAO jd = new JobDAO();
        jobs = jd.getAllJobs();
    } catch (Exception e) {
        e.printStackTrace();
    }
%>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <title>View Jobs - Smart Job Portal</title>

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<!-- ================= HEADER ================= -->

<header class="main-header">

    <div class="logo-area">

        <img src="images/logo.png"
             alt="Smart Job Portal Logo">

        <span>Smart Job Portal</span>

    </div>

    <nav class="main-nav">

        <a href="index.jsp">Home</a>

        <a href="Dashboard.jsp">Dashboard</a>

        <a href="ViewJobs.jsp" class="active">Jobs</a>

        <a href="Profile.jsp">Profile</a>

        <a href="ViewApplications.jsp">Applications</a>

        <a href="LogoutServlet">Logout</a>

    </nav>

</header>


<!-- ================= HERO SECTION ================= -->

<section class="jobs-hero">

    <div class="hero-content">

        <h1>Find Your Dream Job</h1>

        <p>
            Search and apply for the best job opportunities
            with Smart Job Portal.
        </p>

    </div>

</section>


<!-- ================= JOB SECTION ================= -->

<section class="jobs-section">

    <h2>Available Jobs</h2>

    <p class="job-subtitle">
        Explore the latest job opportunities from top companies.
    </p>


    <!-- SEARCH -->

    <div class="search-box">

        <input type="text"
               id="searchInput"
               placeholder="Search Job, Company, Location, Skills..."
               onkeyup="searchJobs()">

    </div>


    <!-- ================= JOB TABLE ================= -->

    <div class="table-container">

        <table id="jobsTable">

            <thead>

                <tr>

                    <th>Job ID</th>

                    <th>Company</th>

                    <th>Job Title</th>

                    <th>Description</th>

                    <th>Location</th>

                    <th>Salary</th>

                    <th>Skills</th>

                    <th>Job Type</th>

                    <th>Posted Date</th>

                    <th>Apply</th>

                </tr>

            </thead>


            <tbody>

                <%
                    if (jobs != null && !jobs.isEmpty()) {

                        for (JobBean jb : jobs) {
                %>

                <tr>

                    <td>
                        <%= jb.getJobId() %>
                    </td>


                    <td>
                        <%= jb.getCompanyName() %>
                    </td>


                    <td>
                        <strong>
                            <%= jb.getTitle() %>
                        </strong>
                    </td>


                    <td>
                        <%= jb.getDescription() %>
                    </td>


                    <td>
                        <%= jb.getLocation() %>
                    </td>


                    <td class="salary">
                        ₹ <%= jb.getSalary() %>
                    </td>


                    <td>
                        <%= jb.getSkills() %>
                    </td>


                    <td>
                        <span class="job-type">
                            <%= jb.getJobType() %>
                        </span>
                    </td>


                    <td>
                        <%= jb.getPostedDate() %>
                    </td>


                    <td>

                        <a href="ApplyJob.jsp?job_id=<%= jb.getJobId() %>"
                           class="apply-btn">

                            Apply

                        </a>

                    </td>

                </tr>

                <%
                        }

                    } else {
                %>

                <tr>

                    <td colspan="10" class="no-jobs">

                        No Jobs Available

                    </td>

                </tr>

                <%
                    }
                %>

            </tbody>

        </table>

    </div>

</section>


<!-- ================= FOOTER ================= -->

<footer class="footer">

    <p>
        © 2026 Smart Job Portal System
    </p>

</footer>


<!-- ================= JAVASCRIPT ================= -->

<script src="js/search.js"></script>

</body>
</html>
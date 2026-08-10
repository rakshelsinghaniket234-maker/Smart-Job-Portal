<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    // Login check
    if (session.getAttribute("user_id") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    String user =
            (String) session.getAttribute("user");

    String email =
            (String) session.getAttribute("email");

    String role =
            (String) session.getAttribute("role");
%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Dashboard - Smart Job Portal</title>

    <link rel="stylesheet"
          href="css/dashboard.css">

</head>

<body>


<!-- ================= HEADER ================= -->

<header class="dashboard-header">

    <div class="dashboard-logo">

        <img src="images/logo.png"
             alt="Smart Job Portal">

        <span>Smart Job Portal</span>

    </div>


    <nav>

        <a href="index.jsp">
            Home
        </a>

        <a href="ViewJobs.jsp">
            View Jobs
        </a>

        <a href="Profile.jsp">
            Profile
        </a>

        <a href="ViewApplications.jsp">
            Applications
        </a>

        <a href="LogoutServlet">
            Logout
        </a>

    </nav>

</header>


<!-- ================= DASHBOARD ================= -->

<div class="dashboard-container">

    <h1>
        Welcome, <%=user%>
    </h1>

    <p>
        Email: <%=email%>
    </p>

    <p>
        Role: <%=role%>
    </p>


    <!-- ================= CARDS ================= -->

    <div class="dashboard-cards">


        <!-- VIEW JOBS -->

        <div class="dashboard-card">

            <h2>🔍 View Jobs</h2>

            <p>
                Search and view available jobs.
            </p>

            <a href="ViewJobs.jsp">
                View Jobs
            </a>

        </div>


        <!-- APPLICATIONS -->

        <div class="dashboard-card">

            <h2>📄 Applications</h2>

            <p>
                View your applied jobs.
            </p>

            <a href="ViewApplications.jsp">
                View Applications
            </a>

        </div>


        <!-- PROFILE -->

        <div class="dashboard-card">

            <h2>👤 Profile</h2>

            <p>
                View and manage your profile.
            </p>

            <a href="Profile.jsp">
                My Profile
            </a>

        </div>


        <!-- ADD JOB -->

        <%
            if ("Employer".equalsIgnoreCase(role)) {
        %>

        <div class="dashboard-card">

            <h2>💼 Add Job</h2>

            <p>
                Add a new job vacancy.
            </p>

            <a href="AddJob.jsp">
                Add Job
            </a>

        </div>

        <%
            }
        %>


    </div>

</div>


<!-- ================= FOOTER ================= -->

<footer>

    <p>
        © 2026 Smart Job Portal System
    </p>

</footer>


</body>

</html>
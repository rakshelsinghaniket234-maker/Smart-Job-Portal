<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    if (session.getAttribute("user_id") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    String jobId = request.getParameter("job_id");
%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Apply Job - Smart Job Portal</title>

    <link rel="stylesheet"
          href="css/style.css">

</head>

<body>

    <header>

        <div class="logo-area">

            <img src="images/logo.png"
                 alt="Smart Job Portal">

            <span>Smart Job Portal</span>

        </div>

        <nav>

            <a href="index.jsp">Home</a>

            <a href="Dashboard.jsp">Dashboard</a>

            <a href="ViewJobs.jsp">Jobs</a>

            <a href="Profile.jsp">Profile</a>

            <a href="LogoutServlet">Logout</a>

        </nav>

    </header>


    <div class="apply-container">

        <h1>Apply For Job</h1>

        <p>
            Are you sure you want to apply for this job?
        </p>

        <form action="ApplyJobServlet"
              method="post">

            <input type="hidden"
                   name="job_id"
                   value="<%= jobId %>">

            <button type="submit">
                Apply Job
            </button>

            <a href="ViewJobs.jsp">
                Cancel
            </a>

        </form>

    </div>


    <footer>

        <p>
            © 2026 Smart Job Portal System
        </p>

    </footer>

</body>

</html>
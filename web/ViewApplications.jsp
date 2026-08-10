<%@page import="java.util.ArrayList"%>
<%@page import="com.task.bean.ApplicationBean"%>
<%@page import="com.task.dao.ApplicationDAO"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    if (session.getAttribute("user_id") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    int userId = Integer.parseInt(
            session.getAttribute("user_id").toString()
    );

    ApplicationDAO dao =
            new ApplicationDAO();

    ArrayList<ApplicationBean> list =
            dao.getApplicationsByUser(userId);
%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>My Applications</title>

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


<div class="container">

    <h1>My Applications</h1>

    <table border="1">

        <tr>

            <th>Application ID</th>
            <th>Job ID</th>
            <th>Apply Date</th>
            <th>Status</th>

        </tr>

        <%
            if (list.size() == 0) {
        %>

        <tr>

            <td colspan="4">
                No Applications Found
            </td>

        </tr>

        <%
            }

            for (ApplicationBean ab : list) {
        %>

        <tr>

            <td>
                <%= ab.getApplication_id() %>
            </td>

            <td>
                <%= ab.getJob_id() %>
            </td>

            <td>
                <%= ab.getApply_date() %>
            </td>

            <td>
                <%= ab.getStatus() %>
            </td>

        </tr>

        <%
            }
        %>

    </table>

</div>


<footer>

    <p>
        © 2026 Smart Job Portal System
    </p>

</footer>

</body>

</html>
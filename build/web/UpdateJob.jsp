<%@page import="java.sql.*"%>
<%@page import="com.task.utility.ConnectionPool"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String jobId = request.getParameter("job_id");

    Connection con = ConnectionPool.connectDB();

    String sql = "SELECT * FROM jobs WHERE job_id=?";

    PreparedStatement ps = con.prepareStatement(sql);

    ps.setInt(1, Integer.parseInt(jobId));

    ResultSet rs = ps.executeQuery();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Update Job</title>
</head>

<body>

<h2>Update Job</h2>

<%
    if(rs.next()) {
%>

<form action="UpdateJobServlet" method="post">

    <input type="hidden"
           name="job_id"
           value="<%=rs.getInt("job_id")%>">

    Title:
    <input type="text"
           name="title"
           value="<%=rs.getString("title")%>">

    <br><br>

    Description:
    <textarea name="description"><%=rs.getString("description")%></textarea>

    <br><br>

    Location:
    <input type="text"
           name="location"
           value="<%=rs.getString("location")%>">

    <br><br>

    Salary:
    <input type="number"
           name="salary"
           value="<%=rs.getDouble("salary")%>">

    <br><br>

    Skills:
    <input type="text"
           name="skills"
           value="<%=rs.getString("skills")%>">

    <br><br>

    Job Type:
    <input type="text"
           name="job_type"
           value="<%=rs.getString("job_type")%>">

    <br><br>

    <input type="submit" value="Update Job">

</form>

<%
    }
%>

</body>
</html>
<%@page import="java.sql.*"%>
<%@page import="com.task.utility.ConnectionPool"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String userId = request.getParameter("user_id");

    if(userId == null) {
        userId = "1";
    }

    Connection con = ConnectionPool.connectDB();

    String sql = "SELECT * FROM users WHERE user_id=?";

    PreparedStatement ps = con.prepareStatement(sql);

    ps.setInt(1, Integer.parseInt(userId));

    ResultSet rs = ps.executeQuery();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Profile</title>
</head>

<body>

<h2>User Profile</h2>

<%
    if(rs.next()) {
%>

<p>User ID: <%=rs.getInt("user_id")%></p>

<p>Name: <%=rs.getString("name")%></p>

<p>Email: <%=rs.getString("email")%></p>

<p>Phone: <%=rs.getString("phone")%></p>

<p>Role: <%=rs.getString("role")%></p>

<p>Address: <%=rs.getString("address")%></p>

<p>Resume: <%=rs.getString("resume")%></p>

<%
    } else {
%>

<p>User not found.</p>

<%
    }
%>

<br>

<a href="Dashboard.jsp">Dashboard</a>

</body>
</html>
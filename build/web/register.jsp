```jsp
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Registration - Smart Job Portal</title>

    <link rel="stylesheet" href="css/style.css">

    <!-- JavaScript -->
    <script src="js/validation.js"></script>
</head>

<body>

<h2>User Registration</h2>

<form action="RegisterServlet"
      method="post"
      onsubmit="return validateRegistration()">

    <label>User ID:</label>
    <input type="number"
           name="user_id"
           required>

    <br><br>

    <label>Name:</label>
    <input type="text"
           id="name"
           name="name"
           placeholder="Enter your name">

    <br><br>

    <label>Email:</label>
    <input type="email"
           id="email"
           name="email"
           placeholder="Enter email">

    <br><br>

    <label>Password:</label>
    <input type="password"
           id="password"
           name="password"
           placeholder="Enter password">

    <br><br>

    <label>Phone:</label>
    <input type="text"
           id="phone"
           name="phone"
           placeholder="Enter 10 digit phone number">

    <br><br>

    <label>Role:</label>

    <select name="role">

        <option value="Candidate">
            Candidate
        </option>

        <option value="Employer">
            Employer
        </option>

    </select>

    <br><br>

    <label>Address:</label>

    <textarea name="address"
              placeholder="Enter address"></textarea>

    <br><br>

    <label>Resume:</label>

    <input type="text"
           name="resume"
           placeholder="Resume file name">

    <br><br>

    <input type="submit"
           value="Register">

</form>

<a href="login.jsp">Already have an account? Login</a>

<br>

<a href="index.jsp">Back to Home</a>

</body>
</html>
```

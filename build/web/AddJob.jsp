```jsp
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

    <title>Add Job</title>

    <link rel="stylesheet"
          href="css/style.css">

    <script src="js/validation.js"></script>

</head>

<body>

<h2>Add New Job</h2>

<form action="AddJobServlet"
      method="post"
      onsubmit="return validateJob()">

    <label>Job ID:</label>

    <input type="number"
           name="job_id"
           required>

    <br><br>


    <label>Employer ID:</label>

    <input type="number"
           name="employer_id"
           required>

    <br><br>


    <label>Job Title:</label>

    <input type="text"
           id="title"
           name="title"
           placeholder="Enter job title">

    <br><br>


    <label>Description:</label>

    <textarea name="description"
              placeholder="Enter job description"></textarea>

    <br><br>


    <label>Location:</label>

    <input type="text"
           id="location"
           name="location"
           placeholder="Enter job location">

    <br><br>


    <label>Salary:</label>

    <input type="number"
           id="salary"
           name="salary"
           placeholder="Enter salary">

    <br><br>


    <label>Skills:</label>

    <input type="text"
           id="skills"
           name="skills"
           placeholder="Java, JDBC, MySQL">

    <br><br>


    <label>Job Type:</label>

    <select name="job_type">

        <option value="Full Time">
            Full Time
        </option>

        <option value="Part Time">
            Part Time
        </option>

        <option value="Internship">
            Internship
        </option>

    </select>

    <br><br>


    <label>Posted Date:</label>

    <input type="date"
           name="posted_date">

    <br><br>


    <input type="submit"
           value="Add Job">

</form>

<a href="Dashboard.jsp">
    Dashboard
</a>

</body>

</html>
```

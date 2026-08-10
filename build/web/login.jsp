<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    // LoginServlet se error message
    String error = request.getParameter("error");

    // Registration successful message
    String msg = request.getParameter("msg");
%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Login - Smart Job Portal</title>

    <!-- Login CSS -->
    <link rel="stylesheet" href="css/login.css">

    <!-- Validation JavaScript -->
    <script src="js/validation.js"></script>

</head>

<body>


<!-- ================= HEADER ================= -->

<header class="login-header">

    <div class="login-logo">

        <img src="images/logo.png"
             alt="Smart Job Portal Logo">

        <span>Smart Job Portal</span>

    </div>


    <nav>

        <a href="index.jsp">
            Home
        </a>

        <a href="ViewJobs.jsp">
            Jobs
        </a>

        <a href="register.jsp">
            Register
        </a>

    </nav>

</header>



<!-- ================= LOGIN SECTION ================= -->

<div class="login-container">

    <div class="login-box">


        <h1>Login</h1>

        <p class="login-subtitle">
            Login to your Smart Job Portal account
        </p>


        <!-- ================= SUCCESS MESSAGE ================= -->

        <%
            if (msg != null) {
        %>

        <div class="success-message">
            <%=msg%>
        </div>

        <%
            }
        %>


        <!-- ================= ERROR MESSAGE ================= -->

        <%
            if (error != null) {
        %>

        <div class="error-message">
            <%=error%>
        </div>

        <%
            }
        %>



        <!-- ================= LOGIN FORM ================= -->

        <form action="LoginServlet"
              method="post"
              onsubmit="return validateLogin()">


            <!-- EMAIL -->

            <div class="form-group">

                <label for="email">
                    Email
                </label>

                <input type="email"
                       id="email"
                       name="email"
                       placeholder="Enter your email"
                       required>

            </div>



            <!-- PASSWORD -->

            <div class="form-group">

                <label for="password">
                    Password
                </label>

                <input type="password"
                       id="password"
                       name="password"
                       placeholder="Enter your password"
                       required>

            </div>



            <!-- LOGIN BUTTON -->

            <button type="submit"
                    class="login-button">

                Login

            </button>


        </form>



        <!-- ================= REGISTER ================= -->

        <div class="register-link">

            <p>
                Don't have an account?
            </p>

            <a href="register.jsp">
                Create New Account
            </a>

        </div>


        <!-- BACK HOME -->

        <div class="home-link">

            <a href="index.jsp">
                ← Back to Home
            </a>

        </div>


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
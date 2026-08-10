<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>SmartJob - Find Your Dream Job</title>

    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<!-- ================= HEADER ================= -->

<header class="main-header">

    <!-- LOGO -->

    <a href="index.jsp" class="site-logo">

        <img src="images/logo.png" alt="SmartJob Logo">

        <div class="logo-text">

            <span class="logo-main">
                SmartJob
            </span>

            <span class="logo-sub">
                SMART CAREER • BETTER FUTURE
            </span>

        </div>

    </a>


    <!-- NAVIGATION -->

    <nav class="main-nav">

        <a href="index.jsp" class="active">
            Home
        </a>

        <a href="ViewJobs.jsp">
            Jobs
        </a>

        <a href="index.jsp#companies">
            Companies
        </a>

        <a href="index.jsp#about">
            About Us
        </a>

        <a href="index.jsp#contact">
            Contact
        </a>

        <a href="login.jsp" class="login-btn">
            Login
        </a>

        <a href="register.jsp" class="register-btn">
            Register
        </a>

    </nav>

</header>


<!-- ================= HERO ================= -->

<section class="hero-section">

    <div class="hero-overlay">

        <div class="hero-content">

            <div class="hero-badge">
                🚀 Find your next opportunity
            </div>

            <h1>
                Find Your <span>Dream Job</span>
            </h1>

            <p>
                Search thousands of jobs from top companies
                and take the next step in your career.
            </p>


            <!-- SEARCH -->

            <form action="ViewJobs.jsp"
                  method="get"
                  class="hero-search">

                <div class="search-field">

                    <span class="search-icon">
                        🔍
                    </span>

                    <input type="text"
                           name="keyword"
                           placeholder="Search job, company, skills or location">

                </div>

                <button type="submit">
                    Search Jobs
                </button>

            </form>


            <!-- POPULAR -->

            <div class="popular-search">

                <span>Popular:</span>

                <a href="ViewJobs.jsp?keyword=Java">
                    Java Developer
                </a>

                <a href="ViewJobs.jsp?keyword=Python">
                    Python
                </a>

                <a href="ViewJobs.jsp?keyword=React">
                    React
                </a>

                <a href="ViewJobs.jsp?keyword=Web Developer">
                    Web Developer
                </a>

            </div>

        </div>

    </div>

</section>


<!-- ================= FEATURES ================= -->

<section class="features-section" id="about">

    <div class="section-heading">

        <span>WHY SMARTJOB?</span>

        <h2>
            Everything You Need To Build Your Career
        </h2>

        <p>
            SmartJob makes finding and applying for jobs
            simple, fast and convenient.
        </p>

    </div>


    <div class="feature-container">

        <div class="feature-card">

            <div class="feature-icon">
                🔍
            </div>

            <h3>
                Find Jobs
            </h3>

            <p>
                Search jobs by title, skills,
                company and location.
            </p>

            <a href="ViewJobs.jsp">
                Explore Jobs →
            </a>

        </div>


        <div class="feature-card">

            <div class="feature-icon">
                📄
            </div>

            <h3>
                Easy Apply
            </h3>

            <p>
                Apply to your favourite jobs
                quickly and easily.
            </p>

            <a href="ViewJobs.jsp">
                Apply Now →
            </a>

        </div>


        <div class="feature-card">

            <div class="feature-icon">
                🏢
            </div>

            <h3>
                Top Companies
            </h3>

            <p>
                Discover opportunities from
                growing companies.
            </p>

            <a href="#companies">
                View Companies →
            </a>

        </div>


        <div class="feature-card">

            <div class="feature-icon">
                🚀
            </div>

            <h3>
                Career Growth
            </h3>

            <p>
                Find opportunities that help
                you grow professionally.
            </p>

            <a href="register.jsp">
                Get Started →
            </a>

        </div>

    </div>

</section>


<!-- ================= COMPANIES ================= -->

<section class="companies-section" id="companies">

    <div class="section-heading">

        <span>TOP EMPLOYERS</span>

        <h2>
            Explore Top Companies
        </h2>

        <p>
            Find exciting career opportunities
            with leading companies.
        </p>

    </div>


    <div class="company-container">

        <div class="company-box">

            <strong>
                💻 Tech Solutions
            </strong>

            <span>
                Technology
            </span>

        </div>


        <div class="company-box">

            <strong>
                🚀 Innovate Labs
            </strong>

            <span>
                Software
            </span>

        </div>


        <div class="company-box">

            <strong>
                🌐 Digital World
            </strong>

            <span>
                IT Services
            </span>

        </div>


        <div class="company-box">

            <strong>
                📊 Future Corp
            </strong>

            <span>
                Business
            </span>

        </div>

    </div>

</section>


<!-- ================= CTA ================= -->

<section class="cta-section">

    <div class="cta-content">

        <h2>
            Ready To Find Your Next Job?
        </h2>

        <p>
            Create your account and start exploring
            new career opportunities today.
        </p>

        <a href="register.jsp" class="cta-btn">
            Create Free Account
        </a>

    </div>

</section>


<!-- ================= FOOTER ================= -->

<footer class="main-footer" id="contact">

    <div class="footer-content">

        <div>

            <h3>
                SmartJob
            </h3>

            <p>
                SmartJob is a job portal designed to
                connect talented job seekers with
                great career opportunities.
            </p>

        </div>


        <div>

            <h4>
                Quick Links
            </h4>

            <a href="index.jsp">
                Home
            </a>

            <a href="ViewJobs.jsp">
                Jobs
            </a>

            <a href="login.jsp">
                Login
            </a>

            <a href="register.jsp">
                Register
            </a>

        </div>


        <div>

            <h4>
                Contact
            </h4>

            <p>
                📧 support@smartjob.com
            </p>

            <p>
                📞 +91 98765 43210
            </p>

            <p>
                📍 India
            </p>

        </div>

    </div>


    <div class="footer-bottom">

        © 2026 SmartJob Portal. All Rights Reserved.

    </div>

</footer>

</body>
</html>
package com.task.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Checks if user is logged in before allowing access to protected pages
 * (Dashboard, ApplyJob, ViewApplications, AddJob, UpdateJob, DeleteJob, Profile).
 */
@WebFilter(urlPatterns = {
        "/Dashboard.jsp",
        "/ApplyJob.jsp",
        "/ViewApplications.jsp",
        "/AddJob.jsp",
        "/UpdateJob.jsp",
        "/DeleteJob.jsp",
        "/Profile.jsp"
})
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // no init needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                          FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        boolean loggedIn = (session != null && session.getAttribute("user") != null);

        if (loggedIn) {
            chain.doFilter(request, response);
        } else {
            res.sendRedirect(req.getContextPath() + "/login.jsp");
        }
    }

    @Override
    public void destroy() {
        // no cleanup needed
    }
}
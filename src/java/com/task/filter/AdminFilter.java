package com.task.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Restricts job posting/updating/deleting actions to Employer/Admin role only.
 * Candidates should not be able to access these pages.
 */
@WebFilter(urlPatterns = {
        "/AddJob.jsp",
        "/UpdateJob.jsp",
        "/DeleteJob.jsp"
})
public class AdminFilter implements Filter {

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

        String role = (session != null) ? (String) session.getAttribute("role") : null;

        if (role != null && (role.equalsIgnoreCase("Employer") || role.equalsIgnoreCase("Admin"))) {
            chain.doFilter(request, response);
        } else {
            req.setAttribute("errorMessage", "Access Denied: Employer/Admin only.");
            req.getRequestDispatcher("/error.jsp").forward(req, res);
        }
    }

    @Override
    public void destroy() {
        // no cleanup needed
    }
}
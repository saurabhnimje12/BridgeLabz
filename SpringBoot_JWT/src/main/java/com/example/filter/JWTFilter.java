package com.example.filter;

import com.example.util.TokenUtility;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTFilter extends HttpFilter {
    private TokenUtility tokenUtility;

    public JWTFilter(TokenUtility tokenUtility) {
        this.tokenUtility = tokenUtility;
    }

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String token = request.getHeader("Authorization");

        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7); // Remove "Bearer " prefix

            try {
                String role = tokenUtility.getRoleFromToken(token);
                Long user_id = tokenUtility.getEmpIdFromToken(token);
                request.setAttribute("role", role);
                request.setAttribute("user_id",user_id);
                // Proceed with the filter chain
                chain.doFilter(request, response);
            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Invalid token");
            }
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Authorization token missing or invalid");
        }
    }

    @Override
    public void init() throws ServletException {
        // Initialize the filter if needed
    }

    @Override
    public void destroy() {
        // Cleanup resources if needed
    }
}

package com.example.filter;

import com.example.utils.TokenUtility;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class JWTFilter extends HttpFilter {
    private TokenUtility tokenUtility;

    public JWTFilter(TokenUtility tokenUtility) {
        this.tokenUtility = tokenUtility;
    }

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = request.getHeader("Authorization");
        System.out.println("in jwt");
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7); // Remove "Bearer " prefix

            try {
                System.out.println("try");
                String role = tokenUtility.getRoleFromToken(token);
                Long userId = tokenUtility.getEmpIdFromToken(token);
                request.setAttribute("role", role);
                request.setAttribute("userId", userId);
                System.out.println("test");
                // Proceed with the filter chain
                chain.doFilter(request, response);
            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                System.out.println("here");
                response.getWriter().write("Invalid token");
                e.printStackTrace();
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

package org.example.electradrivebackend.configuration;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ApiKeyFilter implements Filter {

    private static final String API_KEY_HEADER = "Authorization";
    private static final String API_KEY = System.getenv("API_KEY");
    private static final String CORS_ORIGIN = System.getenv("CORS_ORIGIN");

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Allow preflight requests to pass through
        if (httpRequest.getMethod().equalsIgnoreCase("OPTIONS")) {
            httpResponse.setStatus(HttpServletResponse.SC_OK);
            httpResponse.setHeader("Access-Control-Allow-Origin", CORS_ORIGIN);
            httpResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            httpResponse.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type");
            return;
        }

        String apiKey = httpRequest.getHeader(API_KEY_HEADER);
        System.out.println("\n API Key from request: " + apiKey);

        if (API_KEY != null && API_KEY.equals(apiKey)) {
            System.out.println("API Key is valid.");
            chain.doFilter(request, response);
        } else {
            System.out.println("Invalid API Key.");
            httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid API Key");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("ApiKeyFilter initialized with API_KEY: " + API_KEY);
    }

    @Override
    public void destroy() {
        System.out.println("ApiKeyFilter destroyed.");
    }
}

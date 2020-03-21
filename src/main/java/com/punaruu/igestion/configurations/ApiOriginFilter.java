package com.punaruu.igestion.configurations;

import javax.servlet.*;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
 * Class de paramètrage des filtres http des WS
 *
 * @author TEATA Heiava
 * @since 04/2018
 */

public class ApiOriginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        res.addHeader("Access-Control-Allow-Origin", "*");
        res.addHeader("Access-Control-Allow-Methods", "OPTIONS, OPTION, GET, POST, DELETE, PUT");
        res.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}

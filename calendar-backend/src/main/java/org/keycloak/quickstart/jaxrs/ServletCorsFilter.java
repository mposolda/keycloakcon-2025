package org.keycloak.quickstart.jaxrs;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

/**
 * @author <a href="mailto:mposolda@redhat.com">Marek Posolda</a>
 */
@WebFilter("/ServletCorsFilter")
public class ServletCorsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Hello 3!!! ");
        System.err.println("Helloo 3!!! ");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}

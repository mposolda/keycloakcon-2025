package org.keycloak.quickstart.jaxrs;

import java.io.IOException;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.container.PreMatching;
import jakarta.ws.rs.ext.Provider;

/**
 * @author <a href="mailto:mposolda@redhat.com">Marek Posolda</a>
 */
// @Provider
// @PreMatching
public class CorsFilter implements ContainerRequestFilter, ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext ctx) throws IOException {
        System.out.println("Hello!!! " + ctx.getRequest().getMethod());
        System.err.println("Helloo!!! " + ctx.getRequest().getMethod());
    }

    @Override
    public void filter(ContainerRequestContext req, ContainerResponseContext res) throws IOException {
        System.out.println("Hello 2!!! ");
        System.err.println("Helloo 2!!! ");
    }


}

/*
 * JBoss, Home of Professional Open Source
 * Copyright 2016, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.keycloak.quickstart.jaxrs;

import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/")
public class Resource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("public")
    public Response getPublic(){
        return wrapEvents(List.of(new CalendarEvent("2025-06-05","Public event")));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("secured")
    public Response getSecured() {
        List<CalendarEvent> events = List.of(
                new CalendarEvent("2025-06-20","KeycloakCon Japan"),
                new CalendarEvent("2025-06-16","KubeCon + CloudNativeCon Japan - Day 1"),
                new CalendarEvent("2025-06-17","KubeCon + CloudNativeCon Japan - Day 2")
        );
        return wrapEvents(events);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("admin")
    public Response getAdmin() {
        List<CalendarEvent> events = List.of(new CalendarEvent("2025-06-20","Private event for administrators only"));
        return wrapEvents(events);
    }

    private Response wrapEvents(List<CalendarEvent> events) {
        return Response.ok(events)
                .header("Access-Control-Allow-Origin", "*")
                .build();
    }

}

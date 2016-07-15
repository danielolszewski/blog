package com.dolszewski.blog;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Path("/api")
public class SampleResource {

    private static final DateFormat format = new SimpleDateFormat("y-M-d H:m:s.S");

    @GET
    @Path("/sample")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSample(@Context Request request) throws ParseException {
        Date lastUpdate = format.parse("2016-02-01 00:00:00.123");
        Response.ResponseBuilder responseBuilder = request.evaluatePreconditions(lastUpdate);
        if (responseBuilder == null) {
            responseBuilder = Response.ok("Significantly big payload ");
        }
        return responseBuilder.lastModified(lastUpdate).build();
    }

}

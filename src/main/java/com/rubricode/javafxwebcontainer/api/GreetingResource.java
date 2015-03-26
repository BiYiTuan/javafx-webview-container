/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rubricode.javafxwebcontainer.api;

import org.glassfish.jersey.server.JSONP;

import javax.ws.rs.*;
/**
 *
 * @author chidieberennadi
 */
@Path("greeting")

public class GreetingResource {
    // Because we cannot rely upon the headers being set correctly, we differentiate between
    // the remote and local calls by path.
    @GET
    @Produces({"application/xml", "application/json"})
    public GreetingBean getGreeting() {
        return new GreetingBean("Hello World Local");
    }
    
    @Path("remote")
    @GET
    @Produces({"application/x-javascript"})
    @JSONP(queryParam = JSONP.DEFAULT_QUERY)
    public GreetingBean getGreeting(@QueryParam(JSONP.DEFAULT_QUERY) String callback) {
        return new GreetingBean("Hello World Remote");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.primus.test.ng.api;

import com.primus.test.ng.api.service.BookService;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Olise.Okpala
 */
@Path("book")
public class BookClient
{
    @Inject
    private BookService service;
    
    
    @Path("")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBooks()
    {
        return Response.ok(service.getBooks()).build();
    }
    
}

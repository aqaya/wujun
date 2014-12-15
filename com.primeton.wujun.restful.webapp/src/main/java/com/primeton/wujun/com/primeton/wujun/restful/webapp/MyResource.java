package com.primeton.wujun.com.primeton.wujun.restful.webapp;

import java.net.URI;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.spi.Container;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("/a/{username}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt(@DefaultValue("2") @QueryParam("step") int step,
    		@PathParam("username") String userName, 
    		@DefaultValue("true") @QueryParam("min-m") boolean hasMin) {
        return "Got a!" + userName+step+hasMin;
    }
    
    @GET
    @Path("/b")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt2() {
        return "Got b!";
    }
    
    @PUT
    public Response putContainer() {
		return null;
//        System.out.println("PUT CONTAINER " + container);
//        URI uri = uriInfo.getAbsolutePath();
//        Container c = new Container(container, uri.toString());
//        Response r;
//        if (!MemoryStore.MS.hasContainer(c)) {
//            r = Response.created(uri).build();
//        } else {
//            r = Response.noContent().build();
//        }
//        MemoryStore.MS.createContainer(c);
//        return r;
    }

   
}

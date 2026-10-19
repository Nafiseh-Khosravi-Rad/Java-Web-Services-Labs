package webHelloREST;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/HiHi")
public class HelloResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello Everyone!";
    }
    @GET
    @Path("/html")
    @Produces(MediaType.TEXT_HTML)
    public String sayHelloHTML() {
        return "<html><body><h1>Hello Everyone!</h1></body></html>";
    }
    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public String sayHelloJSON() {
        return "{\"message\":\"Hello Everyone!\"}";
    }
}
package se.ericsson.store.controller;

import org.eclipse.microprofile.metrics.annotation.Counted;
import se.ericsson.store.model.service.BookService;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/bookController")
@Counted
@RequestScoped
public class BookController {

    @EJB
    private BookService bookService;

    @GET
    @Path("/showMessage")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public String showMessage() {
        return bookService.testMessage();
    }

}

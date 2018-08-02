package se.ericsson.store.model.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class BookService {

    public String testMessage() {
        return "This is a simle sample of microprofile and wildfly swarm";
    }
}

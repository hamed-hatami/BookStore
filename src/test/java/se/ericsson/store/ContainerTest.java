package se.ericsson.store;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.swarm.arquillian.DefaultDeployment;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;
import java.net.URI;

@RunWith(Arquillian.class)
@DefaultDeployment(type = DefaultDeployment.Type.JAR)
public class ContainerTest {

    @ArquillianResource
    private URI uri;

    @Test
    public void testDataSourceIsBound() {

        Client client = ClientBuilder.newClient();
        Invocation.Builder request = client.target(uri)
                .path("/api/bookController/showMessage")
                .request();

        Response response = request.get();

        //assertThat(response.getStatusInfo(), is(OK));
        //browser.navigate().to("http://192.168.10.199:8080/BookStore/api/bookController/showMessage");
        //System.out.println(browser.getTitle());
    }
}

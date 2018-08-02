package se.ericsson.store;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.fest.assertions.Assertions.assertThat;

@RunWith(Arquillian.class)
public class ContainerTest extends AbstractIntegrationTest {

    @Drone
    private WebDriver browser;

    @Test
    public void testDataSourceIsBound() throws Exception {

        Log log = getStdOutLog();

        assertThatLog(log).hasLineContaining("WFLYJCA0001: Bound data source [java:jboss/datasources/ExampleDS]");


        browser.navigate().to("http://localhost:8080/");
        assertThat(browser.getPageSource()).contains("Howdy using driver: H2 JDBC Driver");
    }
}

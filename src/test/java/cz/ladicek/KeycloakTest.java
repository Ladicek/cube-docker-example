package cz.ladicek;

import java.net.URL;

import org.arquillian.cube.DockerUrl;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class KeycloakTest {
    @DockerUrl(containerName = "keycloak", exposedPort = 8080, context = "/auth")
    @ArquillianResource
    private URL url;

    @Test
    public void test() {
        System.out.println("!!!! " + url);
    }
}

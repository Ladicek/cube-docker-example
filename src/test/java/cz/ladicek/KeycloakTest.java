package cz.ladicek;

import java.net.URL;

import org.arquillian.cube.DockerUrl;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.keycloak.admin.client.Keycloak;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class KeycloakTest {
    @DockerUrl(containerName = "keycloak", exposedPort = 8080, context = "/auth")
    @ArquillianResource
    private URL url;

    private Keycloak keycloak;

    @Before
    public void setUp() {
        keycloak = Keycloak.getInstance(url.toString(), "master", "admin", "admin", "admin-cli");
    }

    @After
    public void tearDown() {
        keycloak.close();
    }

    @Test
    public void test() {
        assertEquals("2.5.5.Final", keycloak.serverInfo().getInfo().getSystemInfo().getVersion());
    }
}

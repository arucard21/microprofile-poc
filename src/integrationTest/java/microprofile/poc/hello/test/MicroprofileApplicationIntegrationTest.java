package microprofile.poc.hello.test;

import java.nio.file.Paths;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import jakarta.inject.Inject;
import microprofile.poc.hello.HelloWebResource;

@ExtendWith(ArquillianExtension.class)
public class MicroprofileApplicationIntegrationTest {
	final String port = System.getProperty("tomee.httpPort");
	@Inject
	HelloWebResource helloWebResource;

	@Deployment
    public static WebArchive loadPrebuiltWarForDeployment() {
        WebArchive war = ShrinkWrap.createFromZipFile(WebArchive.class, Paths.get("build/libs/microprofile-poc.war").toFile());
        System.out.println(war.toString(true));
        return war;
    }

	@Test
	public void sayHello_returnsHelloWorld() {
		Assertions.assertEquals("Hello World", helloWebResource.sayHello());
	}
}

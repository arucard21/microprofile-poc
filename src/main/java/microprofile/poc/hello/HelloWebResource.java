package microprofile.poc.hello;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
@ApplicationScoped // FIXME Why is this needed to make the fallback mechanism work correctly?
@OpenAPIDefinition(info = @Info(title = "Hello World endpoint", version = "1.0"))
public class HelloWebResource {
	@Inject
	@ConfigProperty(name="injected.value")
	private String injectedConfigurationProperty;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello World";
    }

    @Timed
    @Fallback(HelloFallbackHandler.class)
	@Timeout(500)
	@Path("timeout")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String triggerFallback() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.err.println("Who dares disturb my slumber?!");
		}
		return "Did not trigger fallback";
	}

    @GET
	@Path("config-property")
    @Produces(MediaType.TEXT_PLAIN)
	public String injectedConfigurationProperty() {
		return injectedConfigurationProperty;
	}
}

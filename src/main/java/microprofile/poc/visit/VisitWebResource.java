package microprofile.poc.visit;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("visits")
@ApplicationScoped
@OpenAPIDefinition(info = @Info(title = "Visit endpoint", version = "1.0"))
public class VisitWebResource {
	Map<Long, Visit> visits = new HashMap<>();

	public VisitWebResource() {
		for(int i = 0; i < 3; i++) {
			Visit visit = new Visit();
			visit.setAmountOfVisitors(2);
			visit.setReason("some reason");
			visits.put(Long.valueOf(i), visit);
		}
	}

	/**
	 * TODO use MP Config variables
	 */

	@APIResponses(value = { @APIResponse(responseCode = "200", description = "Retrieve a list of all visits") })
	@Fallback // better use FallbackHandler
	@Timeout(500)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Visit> getVisits(){
		return visits.values();
	}


}

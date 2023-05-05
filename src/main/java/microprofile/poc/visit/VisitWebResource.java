package microprofile.poc.visit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import microprofile.poc.visit.entity.VisitEntity;

@Path("visits")
@RequestScoped
@OpenAPIDefinition(info = @Info(title = "Visit endpoint", version = "1.0"))
public class VisitWebResource {
	Map<Long, Visit> visits = new HashMap<>();
	// FIXME this does not seem to be container-managed persistence, not sure how to enable that.
	// I think this can be injected with @PersistenceContext once configured correctly.
    private EntityManager entityManager = Persistence.createEntityManagerFactory("microprofile-poc-persistence-unit").createEntityManager();

	public VisitWebResource() {
		for(int i = 0; i < 3; i++) {
			VisitEntity entity = new VisitEntity(null, "some persisted reason", 2+i, null, null, null, null);
			entityManager.persist(entity);
		}
	}

	@APIResponses(value = { @APIResponse(responseCode = "200", description = "Retrieve a list of all visits") })
	@Timed
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Visit> getVisits(){
		VisitEntity entity1 = entityManager.find(VisitEntity.class, 0);
		// FIXME can only retrieve entity with 0
//		VisitEntity entity2 = entityManager.find(VisitEntity.class, 1);
//		VisitEntity entity3 = entityManager.find(VisitEntity.class, 2);
		return Stream.of(entity1)//, entity2)//, entity3)
				.map(entity -> new Visit(entity.getReason(), entity.getAmountOfVisitors(), null, null, null, null))
				.toList();
	}
}

package microprofile.poc.visit;

import java.util.List;

import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import microprofile.poc.visit.entity.VisitEntity;

@Path("visits")
@RequestScoped
@OpenAPIDefinition(info = @Info(title = "Visit endpoint", version = "1.0"))
public class VisitWebResource {
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void ensureNonEmptyDatabase() {
		try {
			int databaseSize = entityManager.createQuery("select x from VisitEntity x", VisitEntity.class).getResultList().size();
			if(databaseSize == 0) {
				for(int i = 0; i < 3; i++) {
					VisitEntity entity = new VisitEntity(null, "some persisted reason", 2+i, null, null, null, null);
					entityManager.persist(entity);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@APIResponses(value = { @APIResponse(responseCode = "200", description = "Retrieve a list of all visits") })
	@Transactional
	@Timed
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Visit> getVisits(){
		// must check this here since persistence cannot be used in the constructor or @PostConstruct method.
		// This is not something that would not be needed when using a database normally.
		ensureNonEmptyDatabase();
		return entityManager.createQuery("select x from VisitEntity x", VisitEntity.class).getResultStream()
				.map(entity -> new Visit(entity.getReason(), entity.getAmountOfVisitors(), null, null, null, null))
				.toList();
	}
}

package microprofile.poc.visit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.enterprise.context.ApplicationScoped;
import microprofile.poc.visit.entity.VisitEntity;

@ApplicationScoped
@Repository
public interface VisitRepository extends JpaRepository<VisitEntity, Long> {}

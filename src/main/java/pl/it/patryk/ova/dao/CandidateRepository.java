package pl.it.patryk.ova.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.it.patryk.ova.model.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

}

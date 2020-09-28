package pl.it.patryk.ova.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.it.patryk.ova.model.Candidate;


public interface CandidateService {
    void save(Candidate candidate);
    Page<Candidate> getAllCandidates(Pageable pageable);
    Candidate getCandidateById(Long id);
}

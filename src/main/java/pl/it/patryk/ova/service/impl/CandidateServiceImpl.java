package pl.it.patryk.ova.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.it.patryk.ova.dao.CandidateRepository;
import pl.it.patryk.ova.model.Candidate;
import pl.it.patryk.ova.service.CandidateService;

@Service
public class CandidateServiceImpl implements CandidateService {
    private CandidateRepository candidateRepository;

    @Autowired
    public void setCandidateRepository(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }
    @Override
    public Page<Candidate> getAllCandidates(Pageable pageable) {
        return this.candidateRepository.findAll(pageable);
    }

    @Override
    public Candidate getCandidateById(Long id) {
        return this.candidateRepository.getOne(id);
    }
}

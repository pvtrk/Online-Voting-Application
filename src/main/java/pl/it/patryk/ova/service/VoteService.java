package pl.it.patryk.ova.service;

import org.springframework.stereotype.Service;
import pl.it.patryk.ova.model.Candidate;
import pl.it.patryk.ova.model.User;
import pl.it.patryk.ova.model.Vote;

@Service
public interface VoteService {
    void saveVote(Vote vote);
    boolean processVote(User user, Candidate candidate);
    double getAllVotesCount();
    double getFrequency();
    double getVotesForCandidate(Long id);
    double getVotesPercentage(Long id);
}

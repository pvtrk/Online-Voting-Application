package pl.it.patryk.ova.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.it.patryk.ova.dao.VoteRepository;
import pl.it.patryk.ova.model.Candidate;
import pl.it.patryk.ova.model.User;
import pl.it.patryk.ova.model.Vote;
import pl.it.patryk.ova.service.VoteService;

@Service
public class VoteServiceImpl implements VoteService {
    private final double  PEOPLE_ABLE_TO_VOTE = 30111281;
    private VoteRepository voteRepository;

    @Autowired
    public void setVoteRepository(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @Override
    public void saveVote(Vote vote) {
        this.voteRepository.save(vote);
    }

    @Override
    public boolean processVote(User user, Candidate candidate) {
        try {
            user.authenticateUser();
            candidate.authenticateCandidate();
            Vote vote = new Vote();
            vote.setUser(user);
            vote.setCandidate(candidate);
            this.voteRepository.save(vote);
            return true;

        } catch (IllegalArgumentException err) {
            err.printStackTrace();
            return false;
        }

    }

    @Override
    public double getAllVotesCount() {
        return this.voteRepository.getAllVotesCount();
    }

    @Override
    public double getFrequency() {
        return Math.round(((this.voteRepository.getAllVotesCount() * 100D) / PEOPLE_ABLE_TO_VOTE));
    }

    @Override
    public double getVotesForCandidate(Long id) {
        return this.voteRepository.getVotesNumberForCandidate(id);
    }

    @Override
    public double getVotesPercentage(Long id) {
        return (this.getVotesForCandidate(id)/this.getAllVotesCount());
    }
}

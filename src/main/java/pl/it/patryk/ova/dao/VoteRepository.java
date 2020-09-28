package pl.it.patryk.ova.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.it.patryk.ova.model.Vote;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    @Query("SELECT COUNT(v.id) FROM tvote v")
    double getAllVotesCount();
    @Query("SELECT COUNT(v.id) FROM tvote v WHERE v.candidate.id =:id")
    int getVotesNumberForCandidate(@Param("id") Long id);
}

package pl.it.patryk.ova.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity(name="tcandidate")
public class Candidate extends Politician {

    private String electionProgram;
    private int votes;

    public String getElectionProgram() {
        return electionProgram;
    }

    public void setElectionProgram(String electionProgram) {
        this.electionProgram = electionProgram;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public boolean authenticateCandidate() {
        if(this == null) {
            throw new IllegalArgumentException("Candidate can not be null");
        } else if (this.getId() == null) {
            throw new IllegalArgumentException("Candidate must have an ID!!");
        } else if (this.getElectionProgram() == null) {
            throw new IllegalArgumentException("Candidate does not have any program");
        } else if (this.getFirstName() == null || this.getLastName() == null) {
            throw new IllegalArgumentException("Candidate's first or last name can not be null");
        } else if(!this.getClass().equals(Candidate.class)) {
            throw new IllegalArgumentException("Wrong candidate's object class");
        } else {
            return true;
        }
    }

    public Candidate() {
    }

    public Candidate(String firstName, String lastName, PoliticalParty politicalParty, String electionProgram, int votes) {
        super(firstName, lastName, politicalParty);
        this.electionProgram = electionProgram;
        this.votes = votes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Candidate candidate = (Candidate) o;
        return votes == candidate.votes &&
                electionProgram.equals(candidate.electionProgram);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), electionProgram, votes);
    }
}

package pl.it.patryk.ova.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="tcandidate")
public class Candidate extends Politician {

    private String electionProgram;
    private long votes;

    public String getElectionProgram() {
        return electionProgram;
    }

    public void setElectionProgram(String electionProgram) {
        this.electionProgram = electionProgram;
    }

    public long getVotes() {
        return votes;
    }

    public void setVotes(long votes) {
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
}
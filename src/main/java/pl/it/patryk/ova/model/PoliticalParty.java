package pl.it.patryk.ova.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="tpoliticalParty")
public class PoliticalParty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String charasteristics;
    @OneToMany(mappedBy = "politicalParty")
    private List<Politician> politicians = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharasteristics() {
        return charasteristics;
    }

    public void setCharasteristics(String charasteristics) {
        this.charasteristics = charasteristics;
    }

    public List<Politician> getPoliticians() {
        return politicians;
    }

    public void setPoliticians(List<Politician> politicians) {
        this.politicians = politicians;
    }

    public void addPolitician(Politician politician) {
        this.politicians.add(politician);
        politician.setPoliticalParty(this);
    }
}

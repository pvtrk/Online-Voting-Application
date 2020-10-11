package pl.it.patryk.ova.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name="tpoliticalParty")
public class PoliticalParty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String charasteristics;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PoliticalParty that = (PoliticalParty) o;
        return id.equals(that.id) &&
                name.equals(that.name) &&
                charasteristics.equals(that.charasteristics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, charasteristics);
    }
}

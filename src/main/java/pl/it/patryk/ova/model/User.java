package pl.it.patryk.ova.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="tuser")
public class User extends PortalUser{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String pesel;
    @Column(unique = true)
    private String idNumber;
    private Boolean voted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Boolean isVoted() {
        return voted;
    }

    public void setVoted(Boolean voted) {
        this.voted = voted;
    }

    public User() {
    }

    public User(String firstName, String lastName, String username, String password,
                Long id, String pesel, String idNumber, Boolean voted) {
        super(firstName, lastName, username, password);
        this.id = id;
        this.pesel = pesel;
        this.idNumber = idNumber;
        this.voted = voted;
    }

    public boolean authenticateUser() {
        if(this == null) {
            throw new IllegalArgumentException("User can not be null");
        } else if(this.getId() == null) {
            throw new IllegalArgumentException("User must have an ID!!");
        } else if (this.getIdNumber() == null) {
            throw new IllegalArgumentException("User's id's number cannot be null'");
        } else if (this.getPesel() == null) {
            throw new IllegalArgumentException("User's pesel cannot be null");
        } else if (this.getFirstName() == null || this.getLastName() == null) {
            throw new IllegalArgumentException("User's first or last name can not be null");
        } else if(!this.getClass().equals(User.class)) {
            throw new IllegalArgumentException("Wrong object class");
        } else {
            return true;
        }
    }
}

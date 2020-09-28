package pl.it.patryk.ova;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.it.patryk.ova.dao.CandidateRepository;
import pl.it.patryk.ova.model.Candidate;

@SpringBootApplication
public class OvaApplication {

    public static void main(String[] args) {
        SpringApplication.run(OvaApplication.class, args);

    }

}
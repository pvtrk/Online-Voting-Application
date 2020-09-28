package pl.it.patryk.ova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.it.patryk.ova.dao.CandidateRepository;
import pl.it.patryk.ova.dao.PoliticalPartyRepository;
import pl.it.patryk.ova.dao.UserRepository;
import pl.it.patryk.ova.model.Candidate;
import pl.it.patryk.ova.model.PoliticalParty;
import pl.it.patryk.ova.model.User;
import pl.it.patryk.ova.service.UserService;

@Controller
public class HackController {
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private PoliticalPartyRepository politicalPartyRepository;

    @Autowired
    private UserService userService;

    @GetMapping(value="/x69")
    public String getHacked() {
        for(int i = 0; i < 3; i++) {
            PoliticalParty party = new PoliticalParty();
            party.setName("PIS");
            party.setCharasteristics("TRALAALALA");

            Candidate candidate = new Candidate();
            candidate.setFirstName("Andrzej");
            candidate.setLastName("Dupa");
            candidate.setElectionProgram("dsagfdagd");
            candidate.setVotes(0l);
            candidate.setPoliticalParty(null);
            party.addPolitician(candidate);
            politicalPartyRepository.save(party);
            candidateRepository.save(candidate);
        }

            User patryk = new User("Patryk", "Lacki", "patryk",
                    "patryk", 1L, "18267318", "2873189", false);
            patryk.setId(null);
            this.userService.save(patryk);



        return "hack";
    }
}

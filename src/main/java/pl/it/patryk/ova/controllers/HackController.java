package pl.it.patryk.ova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.it.patryk.ova.dao.CandidateRepository;
import pl.it.patryk.ova.dao.PoliticalPartyRepository;
import pl.it.patryk.ova.model.Candidate;
import pl.it.patryk.ova.model.PoliticalParty;
import pl.it.patryk.ova.model.User;
import pl.it.patryk.ova.service.UserService;

@RestController
public class HackController {

    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private PoliticalPartyRepository politicalPartyRepository;

    @Autowired
    private UserService userService;

    @RequestMapping(value="/x69", method = RequestMethod.GET)
    public ResponseEntity getHacked() {

            PoliticalParty party = new PoliticalParty();
            party.setName("PIS");
            party.setCharasteristics("TRALAALALA");

            PoliticalParty party2 = new PoliticalParty();
            party2.setName("PO");
            party2.setCharasteristics("TRALAALALA");

            PoliticalParty party3 = new PoliticalParty();
            party3.setName("Wiosna Roberta Biedronia");
            party3.setCharasteristics("TRALAALALA");

            PoliticalParty party4 = new PoliticalParty();
            party4.setName("Konfederacja");
            party4.setCharasteristics("TRALAALALA");

            PoliticalParty party5 = new PoliticalParty();
            party5.setName("Federacja");
            party5.setCharasteristics("TRALAALALA");

            PoliticalParty party6 = new PoliticalParty();
            party6.setName("PSL");
            party6.setCharasteristics("TRALAALALA");

            PoliticalParty party7 = new PoliticalParty();
            party7.setName("Ruch Prawdziwa Europa");
            party7.setCharasteristics("TRALAALALA");

            PoliticalParty party8 = new PoliticalParty();
            party8.setName("Unia Pracy");
            party8.setCharasteristics("TRALAALALA");

            PoliticalParty party9 = new PoliticalParty();
            party9.setName("Kongres Nowej Prawicy");
            party9.setCharasteristics("TRALAALALA");


            Candidate candidate = new Candidate();
            candidate.setFirstName("Andrzej");
            candidate.setLastName("Dupa");
            candidate.setElectionProgram("dsagfdagd");
            candidate.setVotes(0);
            candidate.setPoliticalParty(party);

            Candidate bosak = new Candidate("Krzysztof", "Bosak",party4 , "Hitlerowski", 0);
            Candidate biedron = new Candidate("Robert", "Biedroń", party3, "Wiosenny", 0);
            Candidate holownia = new Candidate("Szymon", "Hołownia", null, "TVNowski", 0);
            Candidate jakubiak = new Candidate("Marek", "Jakubiak", party5, "Federacyjne", 0);
            Candidate kosiniak = new Candidate("Władysław", "Kosiniak-Kamysz", party6, "Kamienne", 0);
            Candidate piotrowski = new Candidate("Mirosław Mariusz", "Piotrowski", party7, "Ruch prawdziwie europejski", 0);
            Candidate tanajno = new Candidate("Paweł", "Tanajno", null, "TANAJNO XD", 0);
            Candidate trzaskowski = new Candidate("Rafał", "Trzaskowski", party2, "POwski", 0);
            Candidate witkowski = new Candidate("Waldemar", "Witkowski ", party8, "Unijno-pracujacy", 0);
            Candidate zoltek = new Candidate("Józef", "Żółtek ", party9, "Kongresowo-nowo-prawicowy", 0);


            candidateRepository.save(holownia);
            candidateRepository.save(tanajno);

            politicalPartyRepository.save(party);
            politicalPartyRepository.save(party2);
            politicalPartyRepository.save(party3);
            politicalPartyRepository.save(party4);
            politicalPartyRepository.save(party5);
            politicalPartyRepository.save(party6);
            politicalPartyRepository.save(party7);
            politicalPartyRepository.save(party8);
            politicalPartyRepository.save(party9);
            candidateRepository.save(candidate);
            candidateRepository.save(bosak);
            candidateRepository.save(biedron);
            candidateRepository.save(jakubiak);
            candidateRepository.save(kosiniak);
            candidateRepository.save(piotrowski);
            candidateRepository.save(trzaskowski);
            candidateRepository.save(witkowski);
            candidateRepository.save(zoltek);


            User patryk = new User("Patryk", "Lacki", "patryk",
                    "patryk", 1L, "18267318", "2873189", false);
            patryk.setId(null);
            this.userService.save(patryk);



        return new ResponseEntity(HttpStatus.OK);
    }


}

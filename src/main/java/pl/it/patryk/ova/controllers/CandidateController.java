package pl.it.patryk.ova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import pl.it.patryk.ova.model.Candidate;
import pl.it.patryk.ova.service.CandidateService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CandidateController {

    private CandidateService candidateService;

    @Autowired
    public void setCandidateService(CandidateService candidateService) {
        this.candidateService = candidateService;
    }
    @RequestMapping(value = "/candidates", method = RequestMethod.GET)
    public ResponseEntity<List<Candidate>> getAllCan() {
        List<Candidate> canList = candidateService.getAllCandidates(PageRequest.of(0, 11)).toList();
        return new ResponseEntity<>(canList, HttpStatus.OK);

    }
    /*
    @GetMapping(value = "/moreInfo/{id}")
    public String getInfoAboutCandidate(@PathVariable("id") Long id, Model model) {
        model.addAttribute("candidate", this.candidateService.getCandidateById(id));
        return "moreInfo";
    }

     */


}

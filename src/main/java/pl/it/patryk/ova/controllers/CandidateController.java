package pl.it.patryk.ova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import pl.it.patryk.ova.model.Candidate;
import pl.it.patryk.ova.service.CandidateService;
import pl.it.patryk.ova.service.UserService;
import pl.it.patryk.ova.service.VoteService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CandidateController {

    private CandidateService candidateService;
    private VoteService voteService;
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setCandidateService(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @Autowired
    public void setVoteService(VoteService voteService) {
        this.voteService = voteService;
    }

    @RequestMapping(value = "/candidates", method = RequestMethod.GET)
    public ResponseEntity<List<Candidate>> getAllCan() {
        List<Candidate> canList = candidateService.getAllCandidates(PageRequest.of(0, 11)).toList();
        return new ResponseEntity<>(canList, HttpStatus.OK);

    }

    @RequestMapping(value = "/vote", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void voteForCandidate(@RequestBody Integer candidateId) {
        this.voteService.processVote(this.userService.getUserById(1L), this.candidateService.getCandidateById(Long.valueOf(candidateId)));
    }
    /*
    @GetMapping(value = "/moreInfo/{id}")
    public String getInfoAboutCandidate(@PathVariable("id") Long id, Model model) {
        model.addAttribute("candidate", this.candidateService.getCandidateById(id));
        return "moreInfo";
    }

     */


}

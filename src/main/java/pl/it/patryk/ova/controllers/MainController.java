package pl.it.patryk.ova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.it.patryk.ova.model.Candidate;
import pl.it.patryk.ova.model.User;
import pl.it.patryk.ova.service.CandidateService;
import pl.it.patryk.ova.service.UserService;
import pl.it.patryk.ova.service.VoteService;

@Controller
public class MainController {

    private CandidateService candidateService;
    private VoteService voteService;
    private UserService userService;


    @Autowired
    public void setCandidateService(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @Autowired
    public void setVoteService(VoteService voteService) {
        this.voteService = voteService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/index")
    public String getMainPage(Model model) {
        Page<Candidate> page = this.candidateService.getAllCandidates(PageRequest.of(0,3));
        model.addAttribute("candidatePage", page);
        return "index";
    }

    @GetMapping(value = "/vote/{id}")
    public String makeSure(@PathVariable("id") Long id, Model model) {
        model.addAttribute("candidate", this.candidateService.getCandidateById(id));
        return "confirmation";
    }

    @GetMapping(value = "/confirm/{id}")
    public String confirm(@PathVariable Long id, Model model) {
        if(this.voteService.processVote(this.userService.getUserById(1L), this.candidateService.getCandidateById(id))) {
            model.addAttribute("frequency", this.voteService.getFrequency());
            model.addAttribute("candidateVotes", this.voteService.getVotesForCandidate(id));
            return "thanksData";
        } else {
            return "errorPage";
        }

    }

    @GetMapping(value = "/reject")
    public String reject() {
        return "redirect:/index";
    }
}

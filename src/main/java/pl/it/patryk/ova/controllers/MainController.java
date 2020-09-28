package pl.it.patryk.ova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pl.it.patryk.ova.model.Candidate;
import pl.it.patryk.ova.model.User;
import pl.it.patryk.ova.service.CandidateService;
import pl.it.patryk.ova.service.UserService;
import pl.it.patryk.ova.service.VoteService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collector;

import static java.util.stream.Collectors.toList;

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

    @GetMapping(value = "/candidateList")
    public String getMainPage(Model model, @RequestParam(defaultValue = "0") int page) {
        int currentPage = page;
        int nextPage =  1;
        int previousPage = 0;
        Page<Candidate> candidatesPage = this.candidateService.getAllCandidates(PageRequest.of(page,3));
        int totalPages = candidatesPage.getTotalPages();
        if(currentPage >= 1) {
            previousPage = currentPage - 1;
        } if(currentPage == totalPages) {
            nextPage = currentPage;
        } if(nextPage < totalPages - 1) {
            nextPage = currentPage + 1;
        }
        model.addAttribute("candidatePage", candidatesPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("nextPage", nextPage);
        model.addAttribute("previousPage", previousPage);
        return "index";
    }

    @GetMapping(value = "/vote/{id}")
    public String makeSure(@PathVariable("id") Long id, Model model) {
        model.addAttribute("candidate", this.candidateService.getCandidateById(id));
        model.addAttribute("user", this.userService.getUserById(1L));
        return "confirmation";
    }

    @GetMapping(value = "/confirm/{id}")
    public String confirm(@PathVariable Long id, Model model, @ModelAttribute User user) {
        if(this.voteService.processVote(this.userService.getUserById(1L), this.candidateService.getCandidateById(id))) {
            model.addAttribute("frequency", this.voteService.getFrequency());
            model.addAttribute("candidateVotes", this.voteService.getVotesForCandidate(id));
            model.addAttribute("user", this.userService.getUserById(1L));
            return "thanksData";
        } else {
            return "errorPage";
        }

    }

    @GetMapping(value = "/reject")
    public String reject() {
        return "redirect:/index";
    }

    @GetMapping(value = "/live")
    public String getLiveResults(Model model) {
        model.addAttribute("candidates", this.candidateService.getAllCandidates(PageRequest.of(0,11))
                    .getContent().stream().sorted(Comparator.comparingInt(Candidate::getVotes)).collect(toList()));
        model.addAttribute("totalVotes", this.voteService.getAllVotesCount());

        return "live";
    }
}

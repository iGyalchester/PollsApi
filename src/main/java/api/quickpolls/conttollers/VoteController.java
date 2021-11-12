package api.quickpolls.conttollers;


import api.quickpolls.domains.Vote;

import api.quickpolls.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VoteController {
    @Autowired
    VoteService voteService;
    
    @PostMapping(value="/polls/{pollId}/votes")
    public ResponseEntity<?> createVote(@PathVariable Long pollId, @RequestBody Vote vote) {
        return voteService.createVote(pollId, vote);
    }

    @GetMapping(value="/polls/{pollId}/votes")
    public Iterable<Vote> getAllVotes(@PathVariable Long pollId) {
        return voteService.getAllVotes(pollId);
    }
}

package api.quickpolls.conttollers;


import api.quickpolls.domains.Vote;
import api.quickpolls.repositories.VoteRepository;
import api.quickpolls.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.inject.Inject;

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

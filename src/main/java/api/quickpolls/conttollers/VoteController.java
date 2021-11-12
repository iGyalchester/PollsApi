package api.quickpolls.conttollers;


import api.quickpolls.domains.Vote;
import api.quickpolls.repositories.VoteRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.inject.Inject;

@RestController
public class VoteController {

    @Inject
    private VoteRepository voteRepository;

    @RequestMapping(value="/polls/{pollId}/votes", method= RequestMethod.POST)
    public ResponseEntity<?> createVote(@PathVariable Long pollId, @RequestBody Vote vote) {
        vote = voteRepository.save(vote);

        // Set the headers for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(ServletUriComponentsBuilder.
                fromCurrentRequest().path("/{voteId}").buildAndExpand(vote.getVoteId()).toUri());

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    //GET All Votes Implementation
    @RequestMapping(value="/polls/{pollId}/votes", method=RequestMethod.GET)
    public Iterable<Vote> getAllVotes(@PathVariable Long pollId) {
        return voteRepository.findByPoll(pollId);
    }
}

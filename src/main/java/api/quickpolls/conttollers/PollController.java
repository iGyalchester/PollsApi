package api.quickpolls.conttollers;

import api.quickpolls.domains.Poll;
import api.quickpolls.exception.ResourceNotFoundException;
import api.quickpolls.repositories.PollRepository;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.inject.Inject;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
public class PollController {

    @Inject
    private PollRepository pollRepository;
    protected void verifyPoll(Long pollId) throws ResourceNotFoundException {
        Optional<Poll> poll = pollRepository.findById(pollId);
        if(poll == null) {
            throw new ResourceNotFoundException("Poll with id " + pollId + " not found");
        }
    }

    @RequestMapping(value="/polls", method= RequestMethod.GET)
    public ResponseEntity<Iterable<Poll>> getAllPolls() {
        return new ResponseEntity<>(pollRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value="/polls", method=RequestMethod.POST)
    public ResponseEntity<?> createPoll(@Valid @RequestBody Poll poll) {

        poll = pollRepository.save(poll);

        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPollUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(poll.getPollId())
                .toUri();
        responseHeaders.setLocation(newPollUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    //Retrieving an individual poll
    @RequestMapping(value="/polls/{pollId}", method=RequestMethod.GET)
    public ResponseEntity<?> getPoll(@PathVariable Long pollId) {
        verifyPoll(pollId);

        String message = "Poll with id " + pollId + " not found";
        if(pollRepository.findById(pollId) == null) {
            return new ResponseEntity<>(pollRepository.findById(pollId).get(), HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException(message);
        }
    }

    //Updating an individual poll
    @RequestMapping(value="/polls/{pollId}", method=RequestMethod.PUT)
    public ResponseEntity<?> updatePoll(@RequestBody Poll poll, @PathVariable Long pollId) {
        verifyPoll(pollId);
        // Save the entity
        pollRepository.save(poll);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Deleting an individual poll
    @RequestMapping(value="/polls/{pollId}", method=RequestMethod.DELETE)
    public ResponseEntity<?> deletePoll(@PathVariable Long pollId) {
        verifyPoll(pollId);
        pollRepository.deleteById(pollId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

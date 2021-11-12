package api.quickpolls.conttollers;

import api.quickpolls.domains.Poll;

import api.quickpolls.services.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;


@RestController
@RequestMapping("/polls")
public class PollController {

    @Autowired
    PollService pollService;

    @GetMapping
    public ResponseEntity<Iterable<Poll>> getAllPolls() {
        return pollService.getAllPolls();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPollById(@PathVariable Long id) {
        return pollService.getPoll(id);
    }

    @PostMapping
    public ResponseEntity<?> createPoll(@Valid @RequestBody Poll poll) {
        return pollService.createPoll(poll);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePoll(@PathVariable Long id, @Valid @RequestBody Poll poll) {
        return pollService.updatePoll(poll, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePoll(@PathVariable Long id) {
        return pollService.deletePoll(id);
    }


}

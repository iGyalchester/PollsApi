package api.quickpolls.conttollers;

import api.quickpolls.domains.Vote;
import api.quickpolls.repositories.VoteRepository;
import api.quickpolls.resources.OptionCount;
import api.quickpolls.resources.VoteResult;
import api.quickpolls.services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ComputeResultController {

    @Autowired
    ResultService resultService;

    @GetMapping(value="/computeresult")
    public ResponseEntity<?> computeResult(@RequestParam Long pollId) {
        return resultService.computeResult(pollId);
    }
}

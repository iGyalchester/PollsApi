package api.quickpolls.conttollers;

import api.quickpolls.services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ComputeResultController {

    @Autowired
    ResultService resultService;

    @GetMapping(value="/computeresult")
    public ResponseEntity<?> computeResult(@RequestParam Long pollId) {
        return resultService.computeResult(pollId);
    }
}

package com.example.ebanking.feedback;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @CrossOrigin()
    @GetMapping("/showFeed")
    public List<Feedback> showFeed() {

        return feedbackRepository.findAll();
    }

    @CrossOrigin()
    @PostMapping("/addFeedback")
    public StatusF addFeedback(@Valid @RequestBody Feedback feedback) {

        feedbackRepository.save(feedback);
        return StatusF.ADDED_FEEDBACK;
    }

    @CrossOrigin()
    @DeleteMapping ("/dltFeedback/{fId}")
    public Feedback dltFeedback(@PathVariable long fId) {

         return feedbackRepository.dltFeedback(fId);

    }

}

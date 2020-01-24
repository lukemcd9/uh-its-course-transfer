package edu.hawaii.its.creditxfer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FeedbackController {

        private static final Logger logger = LoggerFactory.getLogger(FeedbackController.class);

        @GetMapping(value = { "/feedback", "/feedback/" })
        public String feedback() {
        logger.debug("User at feedback");
        return "feedback/feedback";
        }

        @PostMapping(value = "/feedback")
        public String feedbackSubmit(@RequestParam String selection, @RequestParam String name, @RequestParam String campusofinterest, @RequestParam String email, @RequestParam String feedbacktext){
            logger.debug("User submitted feedback selection: " + selection + " name: " + name +  " campus of interest: " + campusofinterest + " email: " + email +  " feedbacktext: " + feedbacktext);
            return "redirect:/feedback-success";
        }

        @GetMapping(value = "/feedback-success")
        public String feedbackSuccess() {
        logger.debug("User at feedback-success");
        return "feedback/feedback-success";
        }
}

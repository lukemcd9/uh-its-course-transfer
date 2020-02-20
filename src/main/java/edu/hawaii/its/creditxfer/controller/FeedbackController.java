package edu.hawaii.its.creditxfer.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FeedbackController {

    private static final Log logger = LogFactory.getLog(FeedbackController.class);

    @GetMapping(value = { "/feedback", "/feedback/" })
    public String feedback() {
        logger.debug("User at feedback");
        return "feedback/feedback";
    }

    @PostMapping(value = "/feedback")
    public String feedbackSubmit(@RequestParam String selection, @RequestParam String name, @RequestParam String campusofinterest, @RequestParam String email,
            @RequestParam String feedbacktext) {
        logger.debug("User submitted feedback selection: " + selection + " name: " + name + " campus of interest: " + campusofinterest + " email: " + email + " feedbacktext: "
                + feedbacktext);
        return "redirect:/feedback-success";
    }

    @GetMapping(value = "/feedback-success")
    public String feedbackSuccess() {
        logger.debug("User at feedback-success");
        return "feedback/feedback-success";
    }
}

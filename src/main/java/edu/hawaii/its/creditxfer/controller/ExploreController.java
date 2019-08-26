package edu.hawaii.its.creditxfer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExploreController {

    @GetMapping(value = "/ex")
    public String explore() {
        return "explore";
    }

}

package edu.hawaii.its.creditxfer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListController {

    @GetMapping(value = "/li")
    public String list() {
        return "list";
    }

}

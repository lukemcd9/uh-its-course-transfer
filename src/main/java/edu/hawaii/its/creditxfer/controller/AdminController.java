package edu.hawaii.its.creditxfer.controller;

import java.io.IOException;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {

    @GetMapping(value = { "/admin" })
    public String admin() {
        return "admin";
    }

    @GetMapping("/admin/idle")
    public String idlePage() {
        return "idle";
    }

    ///////////////////////////////////////////////////////////////////////////
    // Exceptions for testing. Remove this stuff at some point.
    //

    private boolean isExceptionTestingEnabled = true;

    public void disableExceptionTesting() {
        isExceptionTestingEnabled = false;
    }

    @RequestMapping(value = "/admin/ioexception", method = RequestMethod.GET)
    public String ioexception() throws IOException {
        if (isExceptionTestingEnabled) {
            throw new IOException("Threw an IOException from admin!");
        }
        return "exception"; // Return view name.
    }

    @RequestMapping(value = "/admin/npe", method = RequestMethod.GET)
    public String npe() throws NullPointerException {
        if (isExceptionTestingEnabled) {
            throw new NullPointerException("Threw an NullPointerException from admin!");
        }
        return "exception"; // Return view name.
    }

}

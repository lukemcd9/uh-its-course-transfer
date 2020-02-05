package edu.hawaii.its.creditxfer.controller;

import edu.hawaii.its.creditxfer.configuration.SpringBootWebApplication;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.runner.RunWith;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringBootWebApplication.class })
public class FeedbackControllerTest{

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    public void feedbackTest() throws Exception {
        mockMvc.perform(get("/feedback"))
                .andExpect(status().isOk())
                .andExpect(view().name("feedback/feedback"));
    }

    @WithMockUhUser
    @Test
    public void feedbackSubmitTest() throws Exception {
        mockMvc.perform(post("/feedback")
                .param("selection", "General")
                .param("name","")
                .param("campusofinterest", "")
                .param("email", "")
                .param("feedbacktext", ""))
                .andExpect(view().name("redirect:/feedback-success"));
    }

    @Test
    public void feedbackSuccessTest() throws Exception {
        mockMvc.perform(get("/feedback-success"))
                .andExpect(status().isOk())
                .andExpect(view().name("feedback/feedback-success"));
    }

}
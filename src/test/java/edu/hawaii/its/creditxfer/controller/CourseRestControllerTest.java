package edu.hawaii.its.creditxfer.controller;


import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import edu.hawaii.its.creditxfer.configuration.SpringBootWebApplication;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringBootWebApplication.class })
public class CourseRestControllerTest {

    private final MediaType APPLICATION_JSON_UTF8 =
        new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    @Autowired
    private CourseRestController restController;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = webAppContextSetup(context).build();
    }

    @Test
    public void testConstruction() {
        assertNotNull(restController);
    }

    @Test
    public void httpGetCourses() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/courses"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(APPLICATION_JSON_UTF8))
            .andExpect(jsonPath("$", hasSize(5000)))
            .andReturn();
        assertNotNull(result);
    }

    @Test
    public void httpGetCoursesBySourceTargetAndSubject() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/courses/source/4867/target/kap/subject/ics"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(APPLICATION_JSON_UTF8))
            .andExpect(jsonPath("$", hasSize(1)))
            .andExpect(jsonPath("$[0].sourceInstitutionCode").value("4867"))
            .andExpect(jsonPath("$[0].mifValue").value("KAP"))
            .andExpect(jsonPath("$[0].subjectCodeTrans").value("ICS"))
            .andExpect(jsonPath("$[0].courseNumberTrans").value("141"))
            .andExpect(jsonPath("$[0].subjectCodeEquiv").value("ICS"))
            .andExpect(jsonPath("$[0].courseNumberEquiv").value("141"))
            .andExpect(jsonPath("$[0].academicPeriodStart").value("000000"))
            .andExpect(jsonPath("$[0].equivCourseAttribute").value("FS"))
            .andExpect(jsonPath("$[0].equivCourseAttributeDesc").value("Foundations: Symbolic Reason"))
            .andExpect(jsonPath("$[0].equivAttrActivityDate").value("2013-10-03"))
            .andReturn();
        assertNotNull(result);
    }
}

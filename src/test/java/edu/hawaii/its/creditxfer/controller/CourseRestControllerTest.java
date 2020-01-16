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
            .andExpect(jsonPath("$", hasSize(9486)))
            .andReturn();
        assertNotNull(result);
    }

    @Test
    public void httpGetCoursesByAttribute() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/courses/attribute/dh"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(APPLICATION_JSON_UTF8))
            .andExpect(jsonPath("$", hasSize(1741)))
            .andExpect(jsonPath("$[0].attribute").value("DH"))
            .andExpect(jsonPath("$[0].start").value("201910"))
            .andExpect(jsonPath("$[0].startDescription").value("Fall 2018"))
            .andExpect(jsonPath("$[0].end").value("999999"))
            .andExpect(jsonPath("$[0].endDescription").value("The End of Time"))
            .andExpect(jsonPath("$[0].mifValue").value("HAW"))
            .andExpect(jsonPath("$[0].subject").value("HWST"))
            .andExpect(jsonPath("$[0].courseNumber").value("100"))
            .andReturn();
        assertNotNull(result);
    }

    @Test
    public void httpGetCoursesBySubject() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/courses/subject/ics"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(APPLICATION_JSON_UTF8))
            .andExpect(jsonPath("$", hasSize(33)))
            .andExpect(jsonPath("$[0].attribute").value("FS"))
            .andExpect(jsonPath("$[0].start").value("200810"))
            .andExpect(jsonPath("$[0].startDescription").value("Fall 2007"))
            .andExpect(jsonPath("$[0].end").value("201845"))
            .andExpect(jsonPath("$[0].endDescription").value("Summer 2018 Accelerated"))
            .andExpect(jsonPath("$[0].mifValue").value("KAP"))
            .andExpect(jsonPath("$[0].subject").value("ICS"))
            .andExpect(jsonPath("$[0].courseNumber").value("141"))
            .andReturn();
        assertNotNull(result);
    }

    @Test
    public void httpGetCoursesBySubjectAndCourseNumber() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/courses/subject/ics/number/141"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(APPLICATION_JSON_UTF8))
            .andExpect(jsonPath("$", hasSize(12)))
            .andExpect(jsonPath("$[0].attribute").value("FS"))
            .andExpect(jsonPath("$[0].start").value("200810"))
            .andExpect(jsonPath("$[0].startDescription").value("Fall 2007"))
            .andExpect(jsonPath("$[0].end").value("201845"))
            .andExpect(jsonPath("$[0].endDescription").value("Summer 2018 Accelerated"))
            .andExpect(jsonPath("$[0].mifValue").value("KAP"))
            .andExpect(jsonPath("$[0].subject").value("ICS"))
            .andExpect(jsonPath("$[0].courseNumber").value("141"))
            .andReturn();
        assertNotNull(result);
    }

    @Test
    public void httpGetCoursesByMif() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/courses/mif/kap"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(APPLICATION_JSON_UTF8))
            .andExpect(jsonPath("$", hasSize(1039)))
            .andExpect(jsonPath("$[0].attribute").value("DH"))
            .andExpect(jsonPath("$[0].start").value("200310"))
            .andExpect(jsonPath("$[0].startDescription").value("Fall 2002"))
            .andExpect(jsonPath("$[0].end").value("200345"))
            .andExpect(jsonPath("$[0].endDescription").value("Summer 2003 Accelerated"))
            .andExpect(jsonPath("$[0].mifValue").value("KAP"))
            .andExpect(jsonPath("$[0].subject").value("AMST"))
            .andExpect(jsonPath("$[0].courseNumber").value("201"))
            .andReturn();
        assertNotNull(result);
    }

    @Test
    public void httpGetCourseByMifValueAndSubjectAndCourseNumber() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/courses/mif/man/subject/ics/number/141/start/200410"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(APPLICATION_JSON_UTF8))
            .andExpect(jsonPath("$.attribute").value("FS"))
            .andExpect(jsonPath("$.start").value("200410"))
            .andExpect(jsonPath("$.startDescription").value("Fall 2003"))
            .andExpect(jsonPath("$.end").value("201845"))
            .andExpect(jsonPath("$.endDescription").value("Summer 2018 Accelerated"))
            .andExpect(jsonPath("$.mifValue").value("MAN"))
            .andExpect(jsonPath("$.subject").value("ICS"))
            .andExpect(jsonPath("$.courseNumber").value("141"))
            .andReturn();
        assertNotNull(result);
    }

}

package edu.hawaii.its.creditxfer.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.Locale;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;

import edu.hawaii.its.creditxfer.configuration.AppConfig;
import edu.hawaii.its.creditxfer.configuration.AppConfigRun;
import edu.hawaii.its.creditxfer.configuration.SpringBootWebApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringBootWebApplication.class })
@ContextConfiguration(classes = {AppConfig.class, AppConfigRun.class})
public class HomeControllerTest {

    @Value("${cas.login.url}")
    private String casLoginUrl;

    @Autowired
    private HomeController homeController;

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
    public void testConstruction() {
        assertNotNull(homeController);
    }

    @Test
    public void testController() throws Exception {
        Model model = new ExtendedModelMap();

        assertEquals("home", homeController.home(Locale.US, model));

        assertFalse(model.asMap().entrySet().isEmpty());
        assertTrue(model.asMap().keySet().contains("systemMessage"));

    }

    @Test
    public void testControllerNullMessage() {
        Model model = new ExtendedModelMap();

        homeController.setMessageNumber(9999);
        homeController.home(Locale.US, model);
        assertTrue(model.asMap().entrySet().isEmpty());
        assertFalse(model.asMap().keySet().contains("systemMessage"));

        homeController.setMessageService(null);
        homeController.home(Locale.US, model);
        assertTrue(model.asMap().entrySet().isEmpty());
        assertFalse(model.asMap().keySet().contains("systemMessage"));
    }

    @Test
    public void requestUrlHome() throws Exception {
        mockMvc.perform(get("/home"))
            .andExpect(status().isOk())
            .andExpect(view().name("home"));
    }

    @Test
    public void requestUrlContact() throws Exception {
        mockMvc.perform(get("/contact"))
            .andExpect(status().isOk())
            .andExpect(view().name("contact"));
    }

    @Test
    public void requestUrlFaq() throws Exception {
        mockMvc.perform(get("/faq"))
            .andExpect(status().isOk())
            .andExpect(view().name("help/faq"));
    }

    @Test
    public void requestUrlGlossary() throws Exception {
        mockMvc.perform(get("/glossary"))
            .andExpect(status().isOk())
            .andExpect(view().name("glossary/glossary"));
    }

    @Test
    public void requestUrlGlossaryId() throws Exception {
        mockMvc.perform(get("/glossary/hon"))
            .andExpect(status().isOk())
            .andExpect(view().name("glossary/glossary-hon"));


        mockMvc.perform(get("/glossary/kcc"))
            .andExpect(status().isOk())
            .andExpect(view().name("glossary/glossary-kcc"));


        mockMvc.perform(get("/glossary/uhh"))
            .andExpect(status().isOk())
            .andExpect(view().name("glossary/glossary-uhh"));


        mockMvc.perform(get("/glossary/uhm"))
            .andExpect(status().isOk())
            .andExpect(view().name("glossary/glossary-uhm"));


        mockMvc.perform(get("/glossary/uhwo"))
            .andExpect(status().isOk())
            .andExpect(view().name("glossary/glossary-uhwo"));


        mockMvc.perform(get("/glossary/wcc"))
            .andExpect(status().isOk())
            .andExpect(view().name("glossary/glossary-wcc"));
    }

    @Test
    public void requestUrlWrong() throws Exception {
        try {
            mockMvc.perform(post("/contact"))
                .andExpect(status().is3xxRedirection());
        } catch (Exception e) {
            fail("Should not reach here. Exception: " + e);
        }
    }

    @Test
    public void requestUrlDenied() throws Exception {
        mockMvc.perform(get("/denied"))
                .andExpect(status().isOk())
                .andExpect(view().name("denied"));
    }

    @Test
    public void requestUrlFonts() throws Exception {
        mockMvc.perform(get("/fonts"))
            .andExpect(status().isOk())
            .andExpect(view().name("help/fonts"));
    }

    @Test public void requestUrlInstitutions() throws Exception {
        mockMvc.perform(get("/institutions"))
            .andExpect(status().isOk())
            .andExpect(view().name("institutions"));
    }

    @Test public void requestUrlInstitutions2() throws Exception {
        mockMvc.perform(get("/institutions2"))
            .andExpect(status().isOk())
            .andExpect(view().name("institutions2"));
    }

    @Test public void requestUrlInstitutions3() throws Exception {
        mockMvc.perform(get("/institutions3"))
            .andExpect(status().isOk())
            .andExpect(view().name("institutions3"));
    }

    @Test
    public void requestUrl404() throws Exception {
        mockMvc.perform(get("/404"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/"));
    }

    @Test
    @WithAnonymousUser
    public void attributesViaAnonymous() throws Exception {
        // Anonymous users not allowed here.
        mockMvc.perform(get("/attributes"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    @WithMockUhUser(username = "uh", roles = { "ROLE_UH" })
    public void requestUrlAttributes() throws Exception {
        mockMvc.perform(get("/attributes"))
                .andExpect(status().isOk())
                .andExpect(view().name("attributes"));
    }

    @Test
    @WithMockUhUser(username = "admin", roles = { "ROLE_UH", "ROLE_ADMIN" })
    public void attributesViaAdmin() throws Exception {
        // Should be high enough role for access.
        mockMvc.perform(get("/attributes"))
                .andExpect(status().isOk())
                .andExpect(view().name("attributes"));
    }



}

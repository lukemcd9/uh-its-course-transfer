package edu.hawaii.its.creditxfer.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlPattern;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;

import edu.hawaii.its.creditxfer.configuration.SpringBootWebApplication;
import edu.hawaii.its.creditxfer.type.Action;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringBootWebApplication.class })
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class AdminControllerTest {

    @Value("${cas.login.url}")
    private String casLoginUrl;

    @Autowired
    private AdminController controller;

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
    @WithMockUhUser(username = "admin", roles = { "ROLE_UH", "ROLE_ADMIN" })
    public void admin() throws Exception {
        mockMvc.perform(get("/admin"))
                .andExpect(status().isOk())
                .andExpect(view().name("admin"));
    }

    @Test
    @WithMockUhUser()
    public void adminViaUh() throws Exception {
        // Not high enough role for access.
        mockMvc.perform(get("/admin"))
            .andExpect(status().is4xxClientError())
            .andExpect(status().is(403));    }

    @Test
    @WithAnonymousUser
    public void adminViaAnonymous() throws Exception {
        // Anonymous users not allowed into admin area.
        mockMvc.perform(get("/admin"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern(casLoginUrl + "**"));
    }

    @Test
    public void actions() {
        Model model = new ExtendedModelMap();
        assertEquals("actions/list", controller.listActions(model));
        Map<String, Object> map = model.asMap();
        assertFalse(map.entrySet().isEmpty());

        @SuppressWarnings("unchecked")
        List<Action> actions = (List<Action>) map.get("actionList");

        Action a0 = actions.get(0);
        assertEquals(10, a0.getId().intValue());
        assertEquals("employee.view.home", a0.getCode());
        a0 = null;

        Action aZ = actions.get(3);
        assertEquals(13, aZ.getId().intValue());
        assertEquals("employee.save.creditxfer", aZ.getCode());
        aZ = null;
    }

    @Test
    public void testEnabledExceptionTesting() {
        Model model = new ExtendedModelMap();
        try {
            controller.ioexception(model);
        } catch (IOException e) {
            assertNotNull(e);
        }
        try {
            controller.npe(model);
        } catch (NullPointerException e) {
            assertNotNull(e);
        }
    }

    @Test
    public void testDisabledExceptionTesting() {
        Model model = new ExtendedModelMap();

        controller.disableExceptionTesting();
        try {
            controller.ioexception(model);
        } catch (Exception e) {
            assertEquals(e, "exception");
        }
        try {
            controller.npe(model);
        } catch (Exception e) {
            assertEquals(e, "exception");
        }
    }
}

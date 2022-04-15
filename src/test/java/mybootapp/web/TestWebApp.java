package mybootapp.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@ContextConfiguration(classes = Starter.class)
@AutoConfigureMockMvc
public class TestWebApp {

    @Autowired
    private MockMvc mvc;



    @Test
    public void testCourseList() throws Exception {
        mvc.perform(get("/course/list"))//
                // afficher
                .andDo(print())//
                // vérifier le statut
                .andExpect(status().isOk())//
                // vérifier le nom de la vue
                .andExpect(view().name("course"))//
                // vérifier le modèle
                .andExpect(model().attributeExists("courses"));
    }

}
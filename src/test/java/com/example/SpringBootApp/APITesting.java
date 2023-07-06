package com.example.SpringBootApp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class APITesting {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldCreate() throws Exception {

        String animalJson = "{\"species\":\"Frog\", \"name\":\"herbert\"}";

        this.mockMvc.perform(post("/addAnimal")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(animalJson))
                        .andExpect(status().isOk());


    }

    @Test
    public void shouldReadAll() throws Exception {

        this.mockMvc.perform(get("/getAllAnimals"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));

    }

    @Test
    public void shouldReadAllById() {

    }

    @Test
    public void shouldUpdate() {

    }

    @Test
    public void shouldDelete() {

    }



}

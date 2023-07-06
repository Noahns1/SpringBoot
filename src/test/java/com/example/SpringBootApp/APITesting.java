package com.example.SpringBootApp;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class APITesting {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    public void shouldCreate() throws Exception {

        String animalJson = "{\"species\":\"Frog\", \"name\":\"herbert\"}";

        this.mockMvc.perform(post("/addAnimal")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(animalJson))
                        .andExpect(status().isOk());


    }

    @Test
    @Order(2)
    public void shouldReadAll() throws Exception {

        this.mockMvc.perform(get("/getAllAnimals"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));

    }

    @Test
    @Order(3)
    public void shouldReadById() throws Exception {

        long ID = 1;

        this.mockMvc.perform(get("/getAnimalById/" + ID))
                .andExpect(status().isOk());

    }

    @Test
    @Order(4)
    public void shouldUpdateById() throws Exception {

        long ID = 1;

        String animalJson = "{\"species\":\"Frog\", \"name\":\"Lil Guy\"}";

        this.mockMvc.perform(post("/updateAnimalById/" + ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(animalJson))
                        .andExpect(status().isOk());

    }

    @Test
    @Order(5)
    public void shouldDelete() throws Exception {

        long ID = 1;

        this.mockMvc.perform(delete("/deleteAnimalById/" + ID))
                .andExpect(status().isOk());

    }



}

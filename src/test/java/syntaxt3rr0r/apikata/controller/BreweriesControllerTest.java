package syntaxt3rr0r.apikata.controller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class BreweriesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllBreweries() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/breweries/"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetOneBrewerie() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/brewerie/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/brewerie/123456789"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
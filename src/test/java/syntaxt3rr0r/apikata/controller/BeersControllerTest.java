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
public class BeersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllBeers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/beers/"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetOneBeer() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/beer/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/beer/123456789"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
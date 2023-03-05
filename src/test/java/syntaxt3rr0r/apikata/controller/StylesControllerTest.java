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
public class StylesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllStyles() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/styles/"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetOneStyle() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/style/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/style/123456789"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
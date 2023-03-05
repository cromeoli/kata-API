package syntaxt3rr0r.apikata.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import syntaxt3rr0r.apikata.modelo.Beers;
import syntaxt3rr0r.apikata.modelo.Categories;
import syntaxt3rr0r.apikata.modelo.Styles;
import syntaxt3rr0r.apikata.repo.CategoriesRepo;
import syntaxt3rr0r.apikata.repo.StylesRepo;

import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootTest
@AutoConfigureMockMvc
public class BeersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CategoriesRepo categoriesRepo;

    @Autowired
    private StylesRepo stylesRepo;


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
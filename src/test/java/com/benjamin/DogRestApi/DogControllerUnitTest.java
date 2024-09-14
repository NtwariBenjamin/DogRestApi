package com.benjamin.DogRestApi;

import com.benjamin.DogRestApi.service.DogService;
import com.benjamin.DogRestApi.web.DogController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DogController.class)
public class DogControllerUnitTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DogService dogService;

    @Test
    public void getAllDogs() throws Exception{
        mockMvc.perform(get("/allDogs/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));

        verify(dogService,times(1)).AllDogs();
    }

    @Test
    public void getDog()throws Exception{
        mockMvc.perform(get("/getDog/Rocky"))
                .andExpect(status().isOk());
        verify(dogService,times(1)).getDog("Rocky");
    }

    @Test
    public void getDogBreed() throws Exception{
        mockMvc.perform(get("/getDogBreed/"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
        verify(dogService,times(1)).getDogBreed();
    }

    @Test
    public void getDogBreedByBreed() throws Exception{
        mockMvc.perform(get("/getDogBreed/chiwawa"))
                .andExpect(status().isOk());
        verify(dogService,times(1)).getDogByBreed("chiwawa");

    }

}


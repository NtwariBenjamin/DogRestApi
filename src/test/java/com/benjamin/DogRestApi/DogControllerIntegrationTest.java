package com.benjamin.DogRestApi;

import com.benjamin.DogRestApi.Entity.Dog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class DogControllerIntegrationTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAllDogs(){
        ResponseEntity<List> response=
                this.restTemplate.getForEntity("http://localhost:"+port+"/allDogs/",List.class);
        assertThat(response.getStatusCode(),equalTo(HttpStatus.OK));
    }

    @Test
    public void getDogByName(){
        ResponseEntity<Dog> response=
                this.restTemplate.getForEntity("http://localhost:"+port+"/getDog/Rocky", Dog.class);
        assertThat(response.getStatusCode(),equalTo(HttpStatus.OK));
    }

    @Test
    public void getDogByBreed(){
        ResponseEntity<Dog> response=
                this.restTemplate.getForEntity("http://localhost:"+port+"/getDogBreed/chiwawa",Dog.class);
        assertThat(response.getStatusCode(),equalTo(HttpStatus.OK));
    }

    @Test
    public void getDogBreed(){
        ResponseEntity<Dog> response=
                this.restTemplate.getForEntity("http://localhost"+port+"/getDogBreed/",Dog.class);
        assertThat(response.getStatusCode(),equalTo(HttpStatus.OK));
    }

 }

package com.galvanize.Controllers;

//DO NOT FORGET to add these in order to use get(), pritn() etc. methods in your MockMcv tests
import static org.hamcrest.Matchers.is;
//import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.galvanize.Models.Movie;
import com.galvanize.Repositories.MovieRepository;
import com.galvanize.Services.GmdbMovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class GmdbRestMovieControllerTests {

    @Autowired
    GmdbMovieService service;

    @Autowired
    MovieRepository repository;

    @Autowired
    MockMvc mvc;

    @Test
    public void searchMovies() throws Exception {
        //you do not need to have ? multiple times when entering multiple parameters
        //you do not need to have %20 (URL encoding) - can just have a blank space
        mvc.perform(get("/movie")).andDo(print()).andExpect(status().isOk());
        mvc.perform(get("/movie?actors=William Shatner")).andDo(print()).andExpect(status().isOk());
        mvc.perform(get("/movie?title=Star")).andDo(print()).andExpect(status().isOk());
        mvc.perform(get("/movie?title=Star Trek&actors=Chris Pine")).andDo(print()).andExpect(status().isOk());
        mvc.perform(get("/movie?title=Start")).andDo(print()).andExpect(status().isNoContent());
        mvc.perform(get("/movie?actors=Wonder Woman")).andDo(print()).andExpect(status().isNoContent());
    }

    @Test
    void getMoviebyId() throws Exception {
        mvc.perform(get("/movie/91")).andDo(print()).andExpect(status().isOk());
        mvc.perform(get("/movie/1")).andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    void getMovie() throws Exception {
        mvc.perform(get("/movie/imdbid/tt2978828")).andDo(print()).andExpect(status().isOk());
        mvc.perform(get("/movie/imdbid/tt")).andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    void getRandomMovies() throws Exception {
        mvc.perform(get("/movies/rand?qty=3")).andDo(print()).andExpect(status().isOk());
        mvc.perform(get("/movies/rand")).andDo(print()).andExpect(status().isOk());
    }
}
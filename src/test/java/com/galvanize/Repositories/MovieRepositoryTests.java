package com.galvanize.Repositories;

import com.galvanize.Models.Movie;
import com.galvanize.Repositories.MovieRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
//@TestPropertySource(locations="classpath:test.properties")
public class MovieRepositoryTests {
//
//    private static int TEST_MOVIES_COUNT = 20;
//    private static String TEST_MOVIE_TITLE_PREFIX = "GMDB JUNIT TEST-";
//
//    private List<Movie> moviesList = new ArrayList<>();

    @Autowired
    MovieRepository movieRepository;

//    @BeforeEach
//    public void setUp() {
//        Movie m;
//        for (int i = 1; i < TEST_MOVIES_COUNT +1; i++) {
//            m = new Movie();
//            m.setTitle(TEST_MOVIE_TITLE_PREFIX +(i*13));
//            m.setImdbId("im"+i*13);
//            //need to populate actors, title, anything I'm using for parms etc.
//            movieRepository.save(m);
//            moviesList.add(m);
//
//        }
//    }

    @Test
    void findAll() {
        List<Movie> movies = movieRepository.findAll();
        System.out.println("\n");
        movies.forEach(System.out::println);
        System.out.println("\n");
        assertTrue(movies.size()>0);
    }

    @Test
    void findAllByTitleContains() {
        List<Movie> movies = movieRepository.findAllByTitleContains("Star");
        System.out.println("\n");
        movies.forEach(System.out::println);
        System.out.println("\n");
        assertTrue(movies.size()==15);
    }

    @Test
    void findAllByActorsContaining() {
        List<Movie> movies = movieRepository.findAllByActorsContaining("William Shatner");
        System.out.println("\n");
        movies.forEach(System.out::println);
        System.out.println("\n");
        assertTrue(movies.size()==4);
    }

    @Test
    void findAllByTitleContainsAndActorsContains() {
        List<Movie> movies = movieRepository.findAllByTitleContainsAndActorsContains("Star Trek", "Chris Pine");
        System.out.println("\n");
        movies.forEach(System.out::println);
        System.out.println("\n");
        assertTrue(movies.size()==3);
    }

    @Test
    void findById() {
        Movie movie = movieRepository.findById(91l).get();
        System.out.println("\n" +movie + "\n");
        assertEquals(91l, movie.getMovieId());
    }

    @Test
    void findMovieByImdbId() {
        Movie movie = movieRepository.findMovieByImdbId("tt2978828");
        System.out.println("\n" +movie + "\n");
        assertEquals("tt2978828", movie.getImdbId());
    }

    @Test
    void findRandomMovies() {
        List<Movie> randomMovies = movieRepository.findRandomMovies(5);
        System.out.println("\n");
        randomMovies.forEach(System.out::println);
        System.out.println("\n");
        assertEquals(5, randomMovies.size());
    }
}

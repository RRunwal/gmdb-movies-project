package com.galvanize.Services;

import com.galvanize.Models.Movie;
import com.galvanize.Repositories.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GmdbMovieServiceTests {

    @Autowired
    GmdbMovieService gmdbMovieService;

    @Test
    void doSearchByTitleAndActors() {
        List<Movie> movies = gmdbMovieService.doSearch("Star Trek", "Chris Pine");
        System.out.println("\n");
        movies.forEach(System.out::println);
        System.out.println("\n");
        assertTrue(movies.size()==3);
    }

    @Test
    void doSearchByTitle() {
        List<Movie> movies = gmdbMovieService.doSearch("Star", null);
        System.out.println("\n");
        movies.forEach(System.out::println);
        System.out.println("\n");
        assertTrue(movies.size()==15);
    }

    @Test
    void doSearchByActors() {
        List<Movie> movies = gmdbMovieService.doSearch(null, "William Shatner");
        System.out.println("\n");
        movies.forEach(System.out::println);
        System.out.println("\n");
        assertTrue(movies.size()==4);
    }

    @Test
    void doSearchFindAll() {
        List<Movie> movies = gmdbMovieService.doSearch(null, null);
        System.out.println("\n");
        movies.forEach(System.out::println);
        System.out.println("\n");
        assertTrue(movies.size()>0);
    }

    @Test
    void getMoviebyId() {
        Movie movie = gmdbMovieService.getMoviebyId(91l).get();
        System.out.println("\n" +movie + "\n");
        assertEquals(91l, movie.getMovieId());
    }

    @Test
    void findMovieByImdbId() {
        Movie movie = gmdbMovieService.getMovie("tt2978828");
        System.out.println("\n" +movie + "\n");
        assertEquals("tt2978828", movie.getImdbId());
    }

    @Test
    void getRandomMovies() {
        List<Movie> randomMovies = gmdbMovieService.getRandomMovies(5);
        System.out.println("\n");
        randomMovies.forEach(System.out::println);
        System.out.println("\n");
        assertEquals(5, randomMovies.size());
    }
}
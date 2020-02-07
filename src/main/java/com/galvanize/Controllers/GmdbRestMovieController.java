package com.galvanize.Controllers;

import com.galvanize.Models.Movie;
import com.galvanize.Models.NoMoviesFoundMatchingCriteriaException;
import com.galvanize.Services.GmdbMovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GmdbRestMovieController {
    private final GmdbMovieService gmdbMovieService;

    public GmdbRestMovieController(GmdbMovieService gmdbMovieService) {
        this.gmdbMovieService = gmdbMovieService;
    }

    @GetMapping("/movie")
    public ResponseEntity<List<Movie>> searchMovies(@RequestParam(required = false) String title,
                                           @RequestParam(required = false) String actors){
        Optional<List<Movie>> movies = Optional.ofNullable(gmdbMovieService.doSearch(title, actors));
        return (movies.isPresent() && movies.get().size()>0? ResponseEntity.ok(movies.get()) : ResponseEntity.status(204).build());
    }

//    @GetMapping("/movie")
//    public List<Movie> searchMovies(@RequestParam(required = false) String title,
//                                                           @RequestParam(required = false) String actors) throws NoMoviesFoundMatchingCriteriaException {
//        List<Movie> movies = gmdbMovieService.doSearch(title, actors);
//        if (movies.size() == 0) {
//            throw new NoMoviesFoundMatchingCriteriaException("No Movies Found Matching Serach Criteria");
//        }
//        return movies;
//    }

    @GetMapping("/movie/{movie_id}")
    public ResponseEntity<Movie> getMoviebyId(@PathVariable Long movie_id) {
        Optional<Movie> movie = gmdbMovieService.getMoviebyId(movie_id);
        return (movie.isPresent())? ResponseEntity.ok(movie.get()) : ResponseEntity.notFound().build();
    }

    @GetMapping("/movie/imdbid/{imdbId}")
    public ResponseEntity<Movie> getMovie(@PathVariable String imdbId){
        Optional<Movie> movie = Optional.ofNullable(gmdbMovieService.getMovie(imdbId));
        return (movie.isPresent())? ResponseEntity.ok(movie.get()) : ResponseEntity.notFound().build();
    }

    @GetMapping("/movies/rand")
    public List<Movie> getRandomMovies(@RequestParam(defaultValue = "5", required = false) int qty){
        return gmdbMovieService.getRandomMovies(qty);
    }

}

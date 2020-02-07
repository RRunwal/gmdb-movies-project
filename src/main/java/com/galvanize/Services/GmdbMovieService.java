package com.galvanize.Services;

import com.galvanize.Models.Movie;
import com.galvanize.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GmdbMovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public GmdbMovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> doSearch(String title, String actors){
        if (title != null && actors != null) {
            return movieRepository.findAllByTitleContainsAndActorsContains(title, actors);
        } else if (actors == null && title != null) {
            return movieRepository.findAllByTitleContains(title);
        }
        else if (title == null && actors != null) {
            return movieRepository.findAllByActorsContaining(actors);
        }
        return movieRepository.findAll();
    }

    public Optional<Movie> getMoviebyId(Long movie_id){
            return movieRepository.findById(movie_id);
    }

    public Movie getMovie(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }

    public List<Movie> getRandomMovies(int quantity){
        return movieRepository.findRandomMovies(quantity);
    }

}

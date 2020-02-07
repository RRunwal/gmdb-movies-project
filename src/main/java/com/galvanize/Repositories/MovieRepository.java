package com.galvanize.Repositories;

import com.galvanize.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
//    ArrayList<Movie> findMovieModelsByTitleContains(String criteria);
    List<Movie> findAllByTitleContains(String title);
    List<Movie> findAllByActorsContaining(String actors);
    List<Movie> findAllByTitleContainsAndActorsContains(String title, String actors);

//    Movie findMovieModelByImdbId(String imdbId);
    Movie findMovieByImdbId(String imdbId);

    @Query(value = "SELECT * from movies m order by RAND() LIMIT ?1", nativeQuery = true)
    List<Movie> findRandomMovies(int qty);

}
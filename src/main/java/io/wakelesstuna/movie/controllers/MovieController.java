package io.wakelesstuna.movie.controllers;

import io.wakelesstuna.movie.entites.request.CreateMovieRequest;
import io.wakelesstuna.movie.entites.response.MovieResponse;
import io.wakelesstuna.movie.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<MovieResponse> createMovie(@RequestBody final CreateMovieRequest request) {
        MovieResponse movie = movieService.createMovie(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(movie);
    }

    @GetMapping
    public ResponseEntity<List<MovieResponse>> getMoviesPagination(@RequestParam(defaultValue = "25", required = false) final Integer size,
                                                                   @RequestParam(defaultValue = "0", required = false) final Integer page) {
        List<MovieResponse> movies = movieService.getAllMovies(size, page);
        return ResponseEntity.ok(movies);
    }

    @GetMapping("{title}")
    public ResponseEntity<MovieResponse> getMovieById(@PathVariable final String title) {
        MovieResponse movie = movieService.getMovieByTitle(title);
        return ResponseEntity.ok(movie);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable final String id) {
        movieService.deleteMovie(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

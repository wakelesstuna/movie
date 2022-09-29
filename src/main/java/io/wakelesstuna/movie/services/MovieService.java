package io.wakelesstuna.movie.services;

import io.wakelesstuna.movie.entites.db.Movie;
import io.wakelesstuna.movie.entites.request.CreateMovieRequest;
import io.wakelesstuna.movie.entites.response.MovieResponse;
import io.wakelesstuna.movie.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private static final String TITLE = "title";
    private final MovieRepository movieRepo;

    public MovieResponse createMovie(final CreateMovieRequest request) {
        Movie movie = new Movie();
        movie.setTitle(request.getTitle());
        movie.setReleaseYear(request.getYear());
        movieRepo.saveAndFlush(movie);

        return MovieResponse.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .year(movie.getReleaseYear())
                .build();
    }

    public List<MovieResponse> getAllMovies(final Integer size, final Integer page) {
        return movieRepo.findAll(PageRequest.of(page, size, Sort.by(TITLE)))
                .map(movie -> MovieResponse.builder()
                        .id(movie.getId())
                        .title(movie.getTitle())
                        .year(movie.getReleaseYear())
                        .build())
                .toList();
    }

    public MovieResponse getMovieByTitle(final String title) {
        return movieRepo.findByTitle(title)
                .map(movie -> MovieResponse.builder()
                        .id(movie.getId())
                        .title(movie.getTitle())
                        .year(movie.getReleaseYear())
                        .build())
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.BAD_REQUEST,
                                "No movie found with title (%s)".formatted(title))
                );
    }

    public void deleteMovie(final String id) {
        movieRepo.deleteById(id);
    }
}

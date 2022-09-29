package io.wakelesstuna.movie.repositories;

import io.wakelesstuna.movie.entites.db.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, String> {
    Optional<Movie> findByTitle(String title);
}

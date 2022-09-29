package io.wakelesstuna.movie.entites.request;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateMovieRequest {
    String title;
    String year;
}

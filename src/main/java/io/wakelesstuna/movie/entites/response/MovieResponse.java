package io.wakelesstuna.movie.entites.response;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class MovieResponse {
    String id;
    String title;
    String year;
}

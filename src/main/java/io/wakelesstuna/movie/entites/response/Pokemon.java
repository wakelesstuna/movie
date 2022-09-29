package io.wakelesstuna.movie.entites.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Pokemon {
    private Integer id;
    private String name;
    private Integer weight;
    private Species species;
}

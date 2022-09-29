package io.wakelesstuna.movie.entites.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
// @Table(name = "this_name_can_be_whatever")
@NoArgsConstructor
@AllArgsConstructor
@Data
@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
public class Movie {

    @Id
    @GeneratedValue(generator = "UUID")
    private String id;
    private String title;
    private String releaseYear;
}

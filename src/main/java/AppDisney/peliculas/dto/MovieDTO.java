package AppDisney.peliculas.dto;

import AppDisney.peliculas.entity.CharacterEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class MovieDTO {

    private Long id;
    private String image;
    private String title;
    private LocalDate creationDate;
    private int rating;
    private Long genderId;
    private List<CharacterEntity> characters;

}

package AppDisney.peliculas.mapper;

import AppDisney.peliculas.entity.MovieEntity;
import AppDisney.peliculas.dto.MovieBasicDTO;
import AppDisney.peliculas.dto.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieMapper {



    public MovieEntity movieDTO2Entity(MovieDTO movieDTO) {
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setImage(movieDTO.getImage());
        movieEntity.setTitle(movieDTO.getTitle());
        movieEntity.setCreationDate(movieDTO.getCreationDate());
        movieEntity.setRating(movieDTO.getRating());
        movieEntity.setGenderId(movieDTO.getGenderId());
        movieEntity.setCharacters(movieDTO.getCharacters());

        return movieEntity;
    }

    public MovieDTO movieEntity2DTO(MovieEntity movieEntity, boolean loadCharacters) {
        MovieDTO  movieDTO = new MovieDTO();
        movieDTO.setId(movieEntity.getId());
        movieDTO.setImage(movieEntity.getImage());
        movieDTO.setTitle(movieEntity.getTitle());
        movieDTO.setCreationDate(movieEntity.getCreationDate());
        movieDTO.setRating(movieEntity.getRating());
        movieDTO.setGenderId(movieEntity.getGenderId());
        movieDTO.setCharacters(movieEntity.getCharacters());

        return movieDTO;
    }

    public List<MovieDTO> movieEntityList2DTOList(List<MovieEntity> movieEntities, boolean loadCharacters) {
        List<MovieDTO> movieDTOS = new ArrayList<>();

        for (MovieEntity entity : movieEntities) {
            movieDTOS.add(this.movieEntity2DTO(entity, loadCharacters));
        }
        return movieDTOS;
    }

    public List<MovieBasicDTO> movieEntityList2BasicDTOList(List<MovieEntity> movieEntities) {
        List<MovieBasicDTO> movieBasicDTOS = new ArrayList<>();
        MovieBasicDTO movieBasicDTO;

        for (MovieEntity entity : movieEntities) {
             movieBasicDTO= new MovieBasicDTO();
            movieBasicDTO.setImage(entity.getImage());
            movieBasicDTO.setTitle(entity.getTitle());
            movieBasicDTO.setCreationDate(entity.getCreationDate());
            movieBasicDTOS.add(movieBasicDTO);
        }
        return movieBasicDTOS;
    }

    public List<MovieEntity> movieDetailedDTOList2EntityList(List<MovieDTO> movieDTOS) {
        List<MovieEntity> movieEntities = new ArrayList<>();

        for (MovieDTO dto : movieDTOS) {
            movieEntities.add(this.movieDTO2Entity(dto));
        }
        return movieEntities;
    }

    public void update(MovieEntity movieEntity, MovieDTO movieDTO) {
        movieEntity.setImage(movieDTO.getImage());
        movieEntity.setTitle(movieDTO.getTitle());
        movieEntity.setCreationDate(movieDTO.getCreationDate());
        movieEntity.setRating(movieDTO.getRating());
        movieEntity.setGenderId(movieDTO.getGenderId());
    }
}

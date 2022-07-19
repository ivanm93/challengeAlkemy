package AppDisney.peliculas.service;

import AppDisney.peliculas.dto.MovieDTO;
import AppDisney.peliculas.entity.CharacterEntity;
import AppDisney.peliculas.entity.MovieEntity;
import AppDisney.peliculas.mapper.MovieMapper;
import AppDisney.peliculas.repository.CharacterRepository;
import AppDisney.peliculas.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private CharacterRepository characterRepository;

    public MovieDTO save (MovieDTO movieDTO) {
        MovieEntity movieEntity = movieMapper.movieDTO2Entity(movieDTO);
        MovieEntity newMovie = movieRepository.save(movieEntity);
        MovieDTO result = movieMapper.movieEntity2DTO(newMovie, true);

        return result;

    }

    public MovieDTO getById(Long id) {
        Optional<MovieEntity> movieEntityOptional = movieRepository.findById(id);

        if (!movieEntityOptional.isPresent()) {
    //aqui iria una excepcion en caso de que no lo encuentre.
        }
        MovieDTO movie = movieMapper.movieEntity2DTO(movieEntityOptional.get(), true);

        return movie;
    }

    public MovieDTO addCharacter(Long id, Long characterId) {
        Optional<MovieEntity> movieEntityOptional = movieRepository.findById(id);

        if (!movieEntityOptional.isPresent()) {
            //Aqui iria una excepcion
            }
        MovieEntity movieEntity = movieEntityOptional.get();

        Optional<CharacterEntity> characterEntityOptional = characterRepository.findById(characterId);

        if (!characterEntityOptional.isPresent()) {
            //Aqui iria una excepcion
        }
        CharacterEntity characterEntity = characterEntityOptional.get();
        movieEntity.getCharacters().add(characterEntity);
        movieRepository.save(movieEntity);
        MovieDTO result = movieMapper.movieEntity2DTO(movieEntity, true);
        return result;
    }

    public MovieDTO deleteCharacter(Long id, Long characterId) {
        Optional<MovieEntity> movieEntityOptional = movieRepository.findById(id);

        if (!movieEntityOptional.isPresent()) {
            //aqui iria una excepcion
        }
        MovieEntity movieEntity = movieEntityOptional.get();

        Optional<CharacterEntity> characterEntityOptional = characterRepository.findById(characterId);

        if (!characterEntityOptional.isPresent()) {
            //Aca iria una excepcion
        }
        CharacterEntity characterEntity = characterEntityOptional.get();
        movieEntity.getCharacters().remove(characterEntity);
        movieRepository.save(movieEntity);
        MovieDTO movieDTO= movieMapper.movieEntity2DTO(movieEntity, true);

        return movieDTO;
    }

    public MovieDTO update(Long id, MovieDTO movieDTO) {
        Optional<MovieEntity> movieEntityOptional = movieRepository.findById(id);

        if (!movieEntityOptional.isPresent()) {
            //Excepcion
        }
        movieMapper.update(movieEntityOptional.get(), movieDTO);
        movieRepository.save(movieEntityOptional.get());
        MovieDTO result = movieMapper.movieEntity2DTO(movieEntityOptional.get(), true);

        return result;
    }

    public void delete(Long id) {
        Optional<MovieEntity> movieEntityOptional = movieRepository.findById(id);

        if (!movieEntityOptional.isPresent()) {
            //Excepcion
        }
        movieRepository.deleteById(id);
    }
}

package AppDisney.peliculas.controller;

import AppDisney.peliculas.dto.MovieDTO;
import AppDisney.peliculas.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    public ResponseEntity<MovieDTO> save(@RequestBody MovieDTO movieDTO) throws Exception {
        MovieDTO newMovie = movieService.save(movieDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(newMovie);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getById(@PathVariable Long id) {
        MovieDTO movieDTO = movieService.getById(id);

        return ResponseEntity.ok(movieDTO);
    }

    @PostMapping("/{id}/characters/{characterId}")
    public ResponseEntity<MovieDTO> addCharacter(@PathVariable Long id, @PathVariable Long characterId) {
        MovieDTO movieDTO = movieService.addCharacter(id, characterId);

        return ResponseEntity.ok().body(movieDTO);
    }

    @DeleteMapping("/{id}/characters/{characterId}")
    public ResponseEntity<MovieDTO> deleteCharacter(@PathVariable Long id, @PathVariable Long characterId) {
        MovieDTO movieDTO = movieService.deleteCharacter(id, characterId);

        return ResponseEntity.ok().body(movieDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDTO> update(@RequestBody MovieDTO movieDTO, @PathVariable Long id) {
        MovieDTO result = movieService.update(id, movieDTO);

        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        movieService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

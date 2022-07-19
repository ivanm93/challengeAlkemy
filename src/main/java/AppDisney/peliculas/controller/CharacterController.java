package AppDisney.peliculas.controller;

import AppDisney.peliculas.dto.CharacterDTO;
import AppDisney.peliculas.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @PostMapping
    public ResponseEntity<CharacterDTO> save (@RequestBody CharacterDTO characterDTO){
        CharacterDTO result = characterService.save (characterDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacterDTO>getById(@PathVariable Long id ){
      CharacterDTO characterDTO = characterService.getById(id);

      return ResponseEntity.ok(characterDTO);
    }

    @PostMapping("/{id}")
    public ResponseEntity<CharacterDTO> update (@PathVariable Long id, @RequestBody CharacterDTO gender) {
        CharacterDTO result = characterService.update(id, gender);

        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id) {
        characterService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

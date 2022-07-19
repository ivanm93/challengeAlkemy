package AppDisney.peliculas.controller;

import AppDisney.peliculas.dto.GenderDTO;
import AppDisney.peliculas.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("genders")
public class GenderController {

    @Autowired
    private GenderService genderService;

    @PostMapping
    public ResponseEntity<GenderDTO> save (@RequestBody GenderDTO genderDTO) {
    GenderDTO newGender = genderService.save(genderDTO);

    return ResponseEntity.status(HttpStatus.CREATED).body(newGender);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenderDTO> getDetailsById(@PathVariable Long id) {
        GenderDTO genderDTO = this.genderService.getDetailsById(id);

        return ResponseEntity.ok(genderDTO);
    }

}

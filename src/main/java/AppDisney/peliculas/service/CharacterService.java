package AppDisney.peliculas.service;

import AppDisney.peliculas.dto.CharacterDTO;
import AppDisney.peliculas.entity.CharacterEntity;
import AppDisney.peliculas.mapper.CharacterMapper;
import AppDisney.peliculas.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CharacterService {

    @Autowired
    private CharacterMapper characterMapper;
    @Autowired
    private CharacterRepository characterRepository;

    public CharacterDTO save(CharacterDTO characterDTO) {
        CharacterEntity characterEntity = characterMapper.characterDTO2Entity(characterDTO);
        CharacterEntity newCharacter = characterRepository.save(characterEntity);
        CharacterDTO result = characterMapper.characterEntity2DTO(newCharacter, true);

        return result;
    }

    public CharacterDTO getById(Long id) {
        Optional<CharacterEntity> characterEntity = characterRepository.findById(id);
        if (!characterEntity.isPresent()) {
            //error excepcion
        }
        CharacterDTO characterDTO = characterMapper.characterEntity2DTO(characterEntity.get(), true);

        return characterDTO;
    }

    public CharacterDTO update(Long id, CharacterDTO characterDTO) {
        Optional<CharacterEntity> characterEntity = characterRepository.findById(id);

        if (!characterEntity.isPresent()) {
            //error excepcion
        }
        characterMapper.update(characterEntity.get(), characterDTO);
        characterRepository.save(characterEntity.get());
        CharacterDTO result = characterMapper.characterEntity2DTO(characterEntity.get(), true);

        return result;
    }

    public void delete(Long id) {
        Optional<CharacterEntity> characterEntity = characterRepository.findById(id);

        if (!characterEntity.isPresent()) {
            //error excepcion
        }
        characterRepository.delete(characterEntity.get());
    }
}
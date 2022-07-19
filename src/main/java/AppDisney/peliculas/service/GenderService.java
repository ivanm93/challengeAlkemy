package AppDisney.peliculas.service;

import AppDisney.peliculas.dto.GenderDTO;
import AppDisney.peliculas.entity.GenderEntity;
import AppDisney.peliculas.mapper.GenderMapper;
import AppDisney.peliculas.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GenderService {

    @Autowired
    private GenderMapper genderMapper;
    @Autowired
    private GenderRepository genderRepository;

    public GenderDTO save(GenderDTO genderDTO){
        GenderEntity genderEntity = genderMapper.genderDTO2Entity(genderDTO);
        GenderEntity newGender = genderRepository.save(genderEntity);
        GenderDTO result = genderMapper.genreEntity2DTO(newGender);

        return result;
    }

    public  GenderDTO getDetailsById(Long id) {
        Optional<GenderEntity> genderEntityOptional = genderRepository.findById(id);

        if (genderEntityOptional.isPresent()) {
            GenderDTO genderDTO = genderMapper.genreEntity2DTO(genderEntityOptional.get());

            return genderDTO;
        }
        return null;
    }

}

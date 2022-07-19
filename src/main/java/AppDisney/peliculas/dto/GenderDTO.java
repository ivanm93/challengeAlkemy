package AppDisney.peliculas.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class GenderDTO {

    private Long id;
    private String name;
    private String image;

}

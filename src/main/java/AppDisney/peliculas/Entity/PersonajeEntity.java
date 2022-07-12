/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppDisney.peliculas.Entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "personaje")
@Getter
@Setter

public class PersonajeEntity {
    
        @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
        
    private String imagen;
    
    private String nombre;
    
    private Long edad;
    
    private Long peso; 
    
    private String historia;
    
    @ManyToMany(mappedBy = "personaje", cascade = CascadeType.ALL)
    private List<PeliculaEntity> paises = new ArrayList<>();

}

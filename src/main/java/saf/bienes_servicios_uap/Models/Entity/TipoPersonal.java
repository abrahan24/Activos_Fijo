package saf.bienes_servicios_uap.Models.Entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tipoPersonal")
@Setter
@Getter
public class TipoPersonal implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipoPersonal;
    @Column(length = 20)
    private String nom_tipoPersonal;
    @Column(length = 2)
    private String estado_tipoPersonal;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoPersonal", fetch = FetchType.LAZY)
	private List<Persona> personas;
}

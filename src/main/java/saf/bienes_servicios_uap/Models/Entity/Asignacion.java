package saf.bienes_servicios_uap.Models.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "asignacion")
@Setter
@Getter
public class Asignacion implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_asignacion;
    private Date fecha_asignacion;
    @Column(length = 2)
    private String estado_asignacion;
    private Integer usuario_mod_a;
    private Integer usuario_reg_a;
    private Date fecha_reg_a;
    private Date fecha_mod_a;
    
    //Tabla Persona;
    @OneToOne
    private Persona persona;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asignacion", fetch = FetchType.LAZY)
	private List<DetalleAsignacion> detalleAsignaciones;
}

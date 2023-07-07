package saf.bienes_servicios_uap.Models.Entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "transferencia")
@Setter
@Getter
public class Transferencia implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_transferencia;
    private Date fecha_transferencia;
    @Column(length = 2)
    private String estado_transferencia;
    private Integer usuario_mod_t;
    private Date fecha_reg_t;
    private Date fecha_mod_t;

    //Tabla Persona ---- Persona Con Activos Asignados
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;
    //Tabla Persona ---- Persona Nueva 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "per_id_persona")
    private Persona per_id_persona;

}

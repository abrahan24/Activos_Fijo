package saf.bienes_servicios_uap.Models.Entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cargo")
@Setter
@Getter
public class Cargo implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cargo;
    @Column(length = 100)
    private String nom_cargo;
    @Column(length = 2)
    private String estado_cargo;
    private Integer usuario_reg_car;
    private Integer usuario_mod_car;
    private Date fecha_reg_car;
    private Date fecha_mod_car;

}

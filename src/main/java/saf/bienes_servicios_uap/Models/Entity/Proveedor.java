package saf.bienes_servicios_uap.Models.Entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "proveedor")
@Setter
@Getter
public class Proveedor implements Serializable{
    
    private Long id_proveedor;
    @Column(length = 100)
    private String nom_proveedor;
    @Column(length = 100)
    private String direccion_prove;
    @Column(length = 20)
    private String celular_prove;
    @Column(length = 30)
    private String correo_prove;
    private Integer nit;
    @Column(length = 30)
    private String ciudad;
    private Integer usuario_reg_prove;
    private Integer usuario_mod_prove;
    private Date fecha_reg_prove;
    private Date fecha_mod_prove;
}

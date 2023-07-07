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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "oficina")
@Setter
@Getter
public class Oficina implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_oficina;
    @Column(length = 150)
    private String nom_oficina;
    @Column(length = 10)
    private String sigla_oficina;
    @Column(length = 2)
    private String estado_oficina;
    private Integer usuario_reg_ofi;
    private Integer usuario_mod_ofi;
    private Date fecha_reg_ofi;
    private Date fecha_mod_ofi;

    //Tabla Unidad Funcional
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_unidadFuncional")
    private UnidadFuncional unidadFuncional;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oficina", fetch = FetchType.LAZY)
	private List<Persona> personas;
}

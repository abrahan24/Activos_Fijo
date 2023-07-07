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
@Table(name = "unidadFuncional")
@Setter
@Getter
public class UnidadFuncional implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_unidadFuncional;
    @Column(length = 100)
    private String nom_unidad;
    @Column(length = 10)
    private String sigla_unidad;
    @Column(length = 2)
    private String estado_unidad;
    private Integer usuario_reg_uf;
    private Integer usuario_mod_uf;
    private Date fecha_reg_uf;
    private Date fecha_mod_uf;

    //Tabla Predio
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_predio")
    private Predio predio;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadFuncional", fetch = FetchType.LAZY)
	private List<Oficina> oficinas;
}

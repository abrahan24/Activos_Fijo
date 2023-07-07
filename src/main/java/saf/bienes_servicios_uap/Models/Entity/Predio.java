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
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "predio")
@Setter
@Getter
public class Predio implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_predio;
    @Column(length = 100)
    private String nom_predio;
    @Column(length = 10)
    private String sigla_predio;
    @Column(length = 2)
    private String estado_predio;
    private Integer usuario_reg_pre;
    private Integer usuario_mod_pre;
    private Date fecha_reg_pre;
    private Date fecha_mod_pre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "predio", fetch = FetchType.LAZY)
	private List<UnidadFuncional> unidadFuncionales;
}

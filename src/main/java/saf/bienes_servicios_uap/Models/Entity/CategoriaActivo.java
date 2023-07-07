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
@Table(name = "categoriaActivo")
@Setter
@Getter
public class CategoriaActivo implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_categoriaActivo;
    @Column(length = 100)
    private String nom_categoria;
    private Double vida_util;
    @Column(length = 2)
    private String estado_categoria;
    private Integer usuario_reg_cat;
    private Integer usuario_mod_cat;
    private Date fecha_reg_cat;
    private Date fecha_mod_cat;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoriaActivo", fetch = FetchType.LAZY)
	private List<TipoActivo> tipoActivos;
}

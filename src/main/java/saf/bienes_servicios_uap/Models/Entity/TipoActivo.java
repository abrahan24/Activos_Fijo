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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tipoActivo")
@Setter
@Getter
public class TipoActivo implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipoActivo;
    @Column(length = 100)
    private String nom_tipo_activo;
    @Column(length = 20)
    private String sigla_tipo_activo;
    @Column(length = 2)
    private String estado_tipo_activo;

    //Tabla Categoria Activo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoriaActivo")
    private CategoriaActivo categoriaActivo;

    //Tabla Marca
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_marca")
    private Marca marca;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoActivo", fetch = FetchType.LAZY)
	private List<Activo> activos;
}

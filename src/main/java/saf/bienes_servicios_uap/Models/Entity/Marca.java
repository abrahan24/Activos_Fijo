package saf.bienes_servicios_uap.Models.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "marca")
@Setter
@Getter
public class Marca implements Serializable{
    
    private Long id_marca;
    @Column(length = 30)
    private String nom_marca;
    @Column(length = 2)
    private String estado_marca;
    private Integer usuario_reg_m;
    private Integer usuario_mod_m;
    private Date fecha_reg_m;
    private Date fecha_mod_m;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "marca", fetch = FetchType.LAZY)
	private List<TipoActivo> tipoActivos;
}

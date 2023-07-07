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
@Table(name = "baja")
@Setter
@Getter
public class Baja implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_baja;
    @Column(length = 20)
    private String cod_baja;
    private Date fecha_baja;
    @Column(length = 100)
    private String descripcion_baja;
    private Integer nro_doc;
    @Column(length = 100)
    private String observacion;
    @Column(length = 2)
    private String estado_baja;
    private Integer usuario_reg_b;
    private Integer usuario_mod_b;
    private Date fecha_reg_b;
    private Date fecha_mod_b;
    
    //Tabla Usuario;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "baja", fetch = FetchType.LAZY)
	private List<DetalleBaja> detalleBajas;
}

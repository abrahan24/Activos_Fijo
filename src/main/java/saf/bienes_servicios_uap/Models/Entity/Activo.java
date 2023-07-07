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
@Table(name = "activo")
@Setter
@Getter
public class Activo implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_activo;
    @Column(length = 20)
    private String cod_activo;
    @Column(length = 200)
    private String descripcion_activo;
    private Date fecha_adquisicion;
    private Double vida_util_activo;
    @Column(length = 2)
    private String estado_activo;
    @Column(length = 50)
    private String serie_activo;
    @Column(length = 30)
    private String marca_activo;
    private Double precio_compra;
    private Integer usuario_reg_ac;
    private Integer usuario_mod_ac;
    private Date fecha_reg_ac;
    private Date fecha_mod_ac;

    //Tabla Tipo Activo
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipoActivo")
    private TipoActivo tipoActivo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activo", fetch = FetchType.LAZY)
	private List<DetalleAsignacion> detalleAsignaciones;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activo", fetch = FetchType.LAZY)
	private List<DetalleBaja> detalleBajas;

    
}

package saf.bienes_servicios_uap.Models.Entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "detalleTransferencia")
@Setter
@Getter
public class DetalleTransferencia implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_detalleTransferencia;
    private Date fecha_detalleTrans;
    @Column(length = 2)
    private String estado_detalleTrans;
    private Integer usuario_reg_det_t;
    private Integer usuario_mod_det_t;
    private Date fecha_reg_det_t;
    private Date fecha_mod_det_t;

    //Tabla Transferencia
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_transferencia")
    private Transferencia transferencia;

    //Tabla Activo
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_activo")
    private Activo activo;


}

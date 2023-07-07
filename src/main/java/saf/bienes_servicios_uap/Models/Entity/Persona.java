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
@Table(name = "persona")
@Setter
@Getter
public class Persona implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_persona;
    @Column(length = 25)
    private String nom_persona;
    @Column(length = 25)
    private String ap_paterno;
    @Column(length = 25)
    private String ap_materno;
    @Column(length = 20)
    private String ci;
    @Column(length = 15)
    private String celular;
    @Column(length = 4)
    private String estado_persona;
    private Integer usuario_reg_per;
    private Integer usuario_mod_per;
    private Date fecha_reg_per;
    private Date fecha_mod_per;
    

    //Tabla Cargo
    @ManyToOne
    private Cargo cargo;

    //Tabla TipoPersonal
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipoPersonal")
    private TipoPersonal tipoPersonal;

    //Tabla Oficina
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina")
    private Oficina oficina;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona", fetch = FetchType.LAZY)
	private List<Transferencia> transferencias;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "per_id_persona", fetch = FetchType.LAZY)
	private List<Transferencia> transferencias_per_i_persona;

    

}

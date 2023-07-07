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
@Table(name = "funcionalidad")
@Setter
@Getter
public class Funcionalidad implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_funcionalidad;
    @Column(length = 30)
    private String nom_funcionalidad;
    @Column(length = 35)
    private String url;
    @Column(length = 2)
    private String estado_funcionalidad;

    //Tabla Rol
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol")
    private Rol rol;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionalidad", fetch = FetchType.LAZY)
	private List<SubFuncionalidad> subFuncionalidades;
}

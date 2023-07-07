package saf.bienes_servicios_uap.Models.Entity;

import java.io.Serializable;

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
@Table(name = "subfuncionalidad")
@Setter
@Getter
public class SubFuncionalidad implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_subFuncionalidad;
    @Column(length = 30)
    private String nom_subFuncionalidad;
    @Column(length = 30)
    private String url_subFun;
    @Column(length = 2)
    private String estado_subFun;

    //Tabla Funcionalidad
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_funcionalidad")
    private Funcionalidad funcionalidad;
}

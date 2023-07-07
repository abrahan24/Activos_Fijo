package saf.bienes_servicios_uap.Models.Dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import saf.bienes_servicios_uap.Models.Entity.Asignacion;

public interface AsignacionDao extends CrudRepository<Asignacion ,Long>{
    
    @Query("SELECT a FROM Asignacion a left join fetch a.persona p WHERE p.ci =?1")
    public Asignacion Buscar_Asignacion_Ci_Persona(String ci);
}

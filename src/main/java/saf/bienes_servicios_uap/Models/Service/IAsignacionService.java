package saf.bienes_servicios_uap.Models.Service;

import java.util.List;

import saf.bienes_servicios_uap.Models.Entity.Asignacion;

public interface IAsignacionService {
    
    public List<Asignacion> findAll();

	public void save(Asignacion asignacion);

	public Asignacion findOne(Long id);

	public void delete(Long id);

	public Asignacion Buscar_Asignacion_Ci_Persona(String ci);
}

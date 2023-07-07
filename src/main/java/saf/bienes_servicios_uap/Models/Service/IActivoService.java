package saf.bienes_servicios_uap.Models.Service;

import java.util.List;

import saf.bienes_servicios_uap.Models.Entity.Activo;

public interface IActivoService {
    
    public List<Activo> findAll();

	public void save(Activo activo);

	public Activo findOne(Long id);

	public void delete(Long id);
}

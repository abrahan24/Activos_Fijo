package saf.bienes_servicios_uap.Models.Service;

import java.util.List;

import saf.bienes_servicios_uap.Models.Entity.Funcionalidad;

public interface IFuncionalidadService {
    
    public List<Funcionalidad> findAll();

	public void save(Funcionalidad funcionalidad);

	public Funcionalidad findOne(Long id);

	public void delete(Long id);
}

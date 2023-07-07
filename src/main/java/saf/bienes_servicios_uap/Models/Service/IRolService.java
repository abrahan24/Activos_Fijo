package saf.bienes_servicios_uap.Models.Service;

import java.util.List;

import saf.bienes_servicios_uap.Models.Entity.Rol;

public interface IRolService {
    
    public List<Rol> findAll();

	public void save(Rol rol);

	public Rol findOne(Long id);

	public void delete(Long id);
}

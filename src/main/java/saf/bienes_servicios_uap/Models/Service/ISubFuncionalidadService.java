package saf.bienes_servicios_uap.Models.Service;

import java.util.List;

import saf.bienes_servicios_uap.Models.Entity.SubFuncionalidad;

public interface ISubFuncionalidadService {
    
    public List<SubFuncionalidad> findAll();

	public void save(SubFuncionalidad subFuncionalidad);

	public SubFuncionalidad findOne(Long id);

	public void delete(Long id);
}

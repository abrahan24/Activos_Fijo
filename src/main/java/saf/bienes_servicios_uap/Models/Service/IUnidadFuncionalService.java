package saf.bienes_servicios_uap.Models.Service;

import java.util.List;

import saf.bienes_servicios_uap.Models.Entity.UnidadFuncional;

public interface IUnidadFuncionalService {
    
    public List<UnidadFuncional> findAll();

	public void save(UnidadFuncional unidadFuncional);

	public UnidadFuncional findOne(Long id);

	public void delete(Long id);
}

package saf.bienes_servicios_uap.Models.Service;

import java.util.List;

import saf.bienes_servicios_uap.Models.Entity.TipoActivo;

public interface ITipoActivoService {
    
    public List<TipoActivo> findAll();

	public void save(TipoActivo tipoActivo);

	public TipoActivo findOne(Long id);

	public void delete(Long id);
}

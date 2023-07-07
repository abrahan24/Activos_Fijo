package saf.bienes_servicios_uap.Models.Service;

import java.util.List;

import saf.bienes_servicios_uap.Models.Entity.TipoPersonal;

public interface ITipoPersonalService {
    
    public List<TipoPersonal> findAll();

	public void save(TipoPersonal tipoPersonal);

	public TipoPersonal findOne(Long id);

	public void delete(Long id);
}

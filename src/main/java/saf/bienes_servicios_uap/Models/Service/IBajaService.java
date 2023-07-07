package saf.bienes_servicios_uap.Models.Service;

import java.util.List;

import saf.bienes_servicios_uap.Models.Entity.Baja;

public interface IBajaService {
    
    public List<Baja> findAll();

	public void save(Baja baja);

	public Baja findOne(Long id);

	public void delete(Long id);
}

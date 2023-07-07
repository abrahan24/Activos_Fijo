package saf.bienes_servicios_uap.Models.Service;

import java.util.List;

import saf.bienes_servicios_uap.Models.Entity.Marca;

public interface IMarcaService {
    
    public List<Marca> findAll();

	public void save(Marca marca);

	public Marca findOne(Long id);

	public void delete(Long id);
}

package saf.bienes_servicios_uap.Models.Service;

import java.util.List;

import saf.bienes_servicios_uap.Models.Entity.Cargo;

public interface ICargoService {
    
    public List<Cargo> findAll();

	public void save(Cargo cargo);

	public Cargo findOne(Long id);

	public void delete(Long id);
}

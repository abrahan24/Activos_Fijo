package saf.bienes_servicios_uap.Models.Service;

import java.util.List;

import saf.bienes_servicios_uap.Models.Entity.Predio;

public interface IPredioService {
    
    public List<Predio> findAll();

	public void save(Predio predio);

	public Predio findOne(Long id);

	public void delete(Long id);
}

package saf.bienes_servicios_uap.Models.Service;

import java.util.List;

import saf.bienes_servicios_uap.Models.Entity.Oficina;

public interface IOficinaService {

    public List<Oficina> findAll();

	public void save(Oficina oficina);

	public Oficina findOne(Long id);

	public void delete(Long id);
}

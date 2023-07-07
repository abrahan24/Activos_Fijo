package saf.bienes_servicios_uap.Models.Service;

import java.util.List;

import saf.bienes_servicios_uap.Models.Entity.CategoriaActivo;

public interface ICategoriaActivoService {
    
    public List<CategoriaActivo> findAll();

	public void save(CategoriaActivo categoriaActivo);

	public CategoriaActivo findOne(Long id);

	public void delete(Long id);
}

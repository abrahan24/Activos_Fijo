package saf.bienes_servicios_uap.Models.Service;

import java.util.List;

import saf.bienes_servicios_uap.Models.Entity.Proveedor;

public interface IProveedorService {
    
    public List<Proveedor> findAll();

	public void save(Proveedor proveedor);

	public Proveedor findOne(Long id);

	public void delete(Long id);
}

package saf.bienes_servicios_uap.Models.Dao;

import org.springframework.data.repository.CrudRepository;

import saf.bienes_servicios_uap.Models.Entity.Proveedor;

public interface ProveedorDao extends CrudRepository<Proveedor, Long>{
    
}

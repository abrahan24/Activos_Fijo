package saf.bienes_servicios_uap.Models.Dao;

import org.springframework.data.repository.CrudRepository;

import saf.bienes_servicios_uap.Models.Entity.Marca;

public interface MarcaDao extends CrudRepository<Marca, Long>{
    
}

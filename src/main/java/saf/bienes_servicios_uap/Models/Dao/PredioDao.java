package saf.bienes_servicios_uap.Models.Dao;

import org.springframework.data.repository.CrudRepository;

import saf.bienes_servicios_uap.Models.Entity.Predio;

public interface PredioDao extends CrudRepository<Predio , Long>{
    
}

package saf.bienes_servicios_uap.Models.Dao;

import org.springframework.data.repository.CrudRepository;

import saf.bienes_servicios_uap.Models.Entity.Transferencia;

public interface TransferenciaDao extends CrudRepository<Transferencia , Long>{
    
}

package saf.bienes_servicios_uap.Models.Service;

import java.util.List;

import saf.bienes_servicios_uap.Models.Entity.DetalleAsignacion;

public interface IDetalleAsignacionService {
    
    public List<DetalleAsignacion> findAll();

	public void save(DetalleAsignacion detalleAsignacion);

	public DetalleAsignacion findOne(Long id);

	public void delete(Long id);
}

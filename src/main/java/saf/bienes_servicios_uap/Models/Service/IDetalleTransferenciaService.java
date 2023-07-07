package saf.bienes_servicios_uap.Models.Service;

import java.util.List;

import saf.bienes_servicios_uap.Models.Entity.DetalleTransferencia;

public interface IDetalleTransferenciaService {
    
    public List<DetalleTransferencia> findAll();

	public void save(DetalleTransferencia detalleTransferencia);

	public DetalleTransferencia findOne(Long id);

	public void delete(Long id);
}

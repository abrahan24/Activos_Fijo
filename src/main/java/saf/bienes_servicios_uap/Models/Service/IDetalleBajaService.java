package saf.bienes_servicios_uap.Models.Service;

import java.util.List;

import saf.bienes_servicios_uap.Models.Entity.DetalleBaja;

public interface IDetalleBajaService {
    
    public List<DetalleBaja> findAll();

	public void save(DetalleBaja detalleBaja);

	public DetalleBaja findOne(Long id);

	public void delete(Long id);
}

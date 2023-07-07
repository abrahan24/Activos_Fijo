package saf.bienes_servicios_uap.Models.Service;

import java.util.List;

import saf.bienes_servicios_uap.Models.Entity.Transferencia;

public interface ITransferenciaService {
    
    public List<Transferencia> findAll();

	public void save(Transferencia transferencia);

	public Transferencia findOne(Long id);

	public void delete(Long id);
}

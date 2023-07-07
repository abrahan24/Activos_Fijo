package saf.bienes_servicios_uap.Models.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import saf.bienes_servicios_uap.Models.Dao.DetalleAsignacionDao;
import saf.bienes_servicios_uap.Models.Entity.DetalleAsignacion;

@Service
public class DetalleAsignacionServiceImpl implements IDetalleAsignacionService{

    @Autowired
    private DetalleAsignacionDao detalleAsignacionDao;

    @Override
    public List<DetalleAsignacion> findAll() {
        // TODO Auto-generated method stub
        return (List<DetalleAsignacion>) detalleAsignacionDao.findAll();
    }

    @Override
    public void save(DetalleAsignacion detalleAsignacion) {
        // TODO Auto-generated method stub
        detalleAsignacionDao.save(detalleAsignacion);
    }

    @Override
    public DetalleAsignacion findOne(Long id) {
        // TODO Auto-generated method stub
        return detalleAsignacionDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        detalleAsignacionDao.deleteById(id);
    }
    
}

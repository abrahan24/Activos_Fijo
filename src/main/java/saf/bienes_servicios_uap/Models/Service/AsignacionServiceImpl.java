package saf.bienes_servicios_uap.Models.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import saf.bienes_servicios_uap.Models.Dao.AsignacionDao;
import saf.bienes_servicios_uap.Models.Entity.Asignacion;

@Service
public class AsignacionServiceImpl implements IAsignacionService{

    @Autowired
    private AsignacionDao asignacionDao;

    @Override
    public List<Asignacion> findAll() {
        // TODO Auto-generated method stub
        return (List<Asignacion>) asignacionDao.findAll();
    }

    @Override
    public void save(Asignacion asignacion) {
        // TODO Auto-generated method stub
        asignacionDao.save(asignacion);
    }

    @Override
    public Asignacion findOne(Long id) {
        // TODO Auto-generated method stub
        return asignacionDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        asignacionDao.deleteById(id);
    }

    @Override
    public Asignacion Buscar_Asignacion_Ci_Persona(String ci) {
        // TODO Auto-generated method stub
        return asignacionDao.Buscar_Asignacion_Ci_Persona(ci);
    }
    
}

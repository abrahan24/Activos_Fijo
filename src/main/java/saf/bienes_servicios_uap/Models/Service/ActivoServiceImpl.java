package saf.bienes_servicios_uap.Models.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import saf.bienes_servicios_uap.Models.Dao.ActivoDao;
import saf.bienes_servicios_uap.Models.Entity.Activo;

@Service
public class ActivoServiceImpl implements IActivoService{

    @Autowired
    private ActivoDao activoDao;

    @Override
    public List<Activo> findAll() {
        // TODO Auto-generated method stub
        return (List<Activo>) activoDao.findAll();
    }

    @Override
    public void save(Activo activo) {
        // TODO Auto-generated method stub
        activoDao.save(activo);
    }

    @Override
    public Activo findOne(Long id) {
        // TODO Auto-generated method stub
        return activoDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        activoDao.deleteById(id);
    }
    
}

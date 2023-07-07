package saf.bienes_servicios_uap.Models.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import saf.bienes_servicios_uap.Models.Dao.TipoActivoDao;
import saf.bienes_servicios_uap.Models.Entity.TipoActivo;

@Service
public class TipoActivoServiceImpl implements ITipoActivoService{

    @Autowired
    private TipoActivoDao tipoActivoDao;

    @Override
    public List<TipoActivo> findAll() {
        // TODO Auto-generated method stub
        return (List<TipoActivo>) tipoActivoDao.findAll();
    }

    @Override
    public void save(TipoActivo tipoActivo) {
        // TODO Auto-generated method stub
        tipoActivoDao.save(tipoActivo);
    }

    @Override
    public TipoActivo findOne(Long id) {
        // TODO Auto-generated method stub
        return tipoActivoDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        tipoActivoDao.deleteById(id);
    }
    
}

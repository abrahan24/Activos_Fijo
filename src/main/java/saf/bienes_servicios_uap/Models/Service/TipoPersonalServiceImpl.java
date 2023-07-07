package saf.bienes_servicios_uap.Models.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import saf.bienes_servicios_uap.Models.Dao.TipoPersonalDao;
import saf.bienes_servicios_uap.Models.Entity.TipoPersonal;

@Service
public class TipoPersonalServiceImpl implements ITipoPersonalService{

    @Autowired
    private TipoPersonalDao tipoPersonalDao;

    @Override
    public List<TipoPersonal> findAll() {
        // TODO Auto-generated method stub
        return (List<TipoPersonal>) tipoPersonalDao.findAll();
    }

    @Override
    public void save(TipoPersonal tipoPersonal) {
        // TODO Auto-generated method stub
        tipoPersonalDao.save(tipoPersonal);
    }

    @Override
    public TipoPersonal findOne(Long id) {
        // TODO Auto-generated method stub
        return tipoPersonalDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        tipoPersonalDao.deleteById(id);
    }
    
}

package saf.bienes_servicios_uap.Models.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import saf.bienes_servicios_uap.Models.Dao.BajaDao;
import saf.bienes_servicios_uap.Models.Entity.Baja;

@Service
public class BajaServiceImpl implements IBajaService{

    @Autowired
    private BajaDao bajaDao;

    @Override
    public List<Baja> findAll() {
        // TODO Auto-generated method stub
        return (List<Baja>) bajaDao.findAll();
    }

    @Override
    public void save(Baja baja) {
        // TODO Auto-generated method stub
        bajaDao.save(baja);
    }

    @Override
    public Baja findOne(Long id) {
        // TODO Auto-generated method stub
        return bajaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        bajaDao.deleteById(id);
    }
    
}

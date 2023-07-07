package saf.bienes_servicios_uap.Models.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import saf.bienes_servicios_uap.Models.Dao.PredioDao;
import saf.bienes_servicios_uap.Models.Entity.Predio;

@Service
public class PredioServiceImpl implements IPredioService{

    @Autowired
    private PredioDao predioDao;

    @Override
    public List<Predio> findAll() {
        // TODO Auto-generated method stub
        return (List<Predio>) predioDao.findAll();
    }

    @Override
    public void save(Predio predio) {
        // TODO Auto-generated method stub
        predioDao.save(predio);
    }

    @Override
    public Predio findOne(Long id) {
        // TODO Auto-generated method stub
        return predioDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        predioDao.deleteById(id);
    }
    
}

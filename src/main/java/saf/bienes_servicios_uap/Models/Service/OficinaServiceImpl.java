package saf.bienes_servicios_uap.Models.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import saf.bienes_servicios_uap.Models.Dao.OficinaDao;
import saf.bienes_servicios_uap.Models.Entity.Oficina;

@Service
public class OficinaServiceImpl implements IOficinaService{

    @Autowired
    private OficinaDao oficinaDao;

    @Override
    public List<Oficina> findAll() {
        // TODO Auto-generated method stub
        return (List<Oficina>) oficinaDao.findAll();
    }

    @Override
    public void save(Oficina oficina) {
        // TODO Auto-generated method stub
        oficinaDao.save(oficina);
    }

    @Override
    public Oficina findOne(Long id) {
        // TODO Auto-generated method stub
        return oficinaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        oficinaDao.deleteById(id);
    }
    
}

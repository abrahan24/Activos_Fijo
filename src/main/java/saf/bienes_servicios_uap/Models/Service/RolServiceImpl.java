package saf.bienes_servicios_uap.Models.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import saf.bienes_servicios_uap.Models.Dao.RolDao;
import saf.bienes_servicios_uap.Models.Entity.Rol;

@Service
public class RolServiceImpl implements IRolService{

    @Autowired
    private RolDao rolDao;

    @Override
    public List<Rol> findAll() {
        // TODO Auto-generated method stub
        return (List<Rol>) rolDao.findAll();
    }

    @Override
    public void save(Rol rol) {
        // TODO Auto-generated method stub
        rolDao.save(rol);
    }

    @Override
    public Rol findOne(Long id) {
        // TODO Auto-generated method stub
        return rolDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        rolDao.deleteById(id);
    }
    
}

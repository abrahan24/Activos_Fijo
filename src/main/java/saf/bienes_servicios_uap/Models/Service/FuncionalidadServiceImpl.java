package saf.bienes_servicios_uap.Models.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import saf.bienes_servicios_uap.Models.Dao.FuncionalidadDao;
import saf.bienes_servicios_uap.Models.Entity.Funcionalidad;

@Service
public class FuncionalidadServiceImpl implements IFuncionalidadService{

    @Autowired
    private FuncionalidadDao funcionalidadDao;

    @Override
    public List<Funcionalidad> findAll() {
        // TODO Auto-generated method stub
        return (List<Funcionalidad>) funcionalidadDao.findAll();
    }

    @Override
    public void save(Funcionalidad funcionalidad) {
        // TODO Auto-generated method stub
        funcionalidadDao.save(funcionalidad);
    }

    @Override
    public Funcionalidad findOne(Long id) {
        // TODO Auto-generated method stub
        return funcionalidadDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        funcionalidadDao.deleteById(id);
    }
    
}

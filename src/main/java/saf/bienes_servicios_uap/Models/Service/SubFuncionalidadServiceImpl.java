package saf.bienes_servicios_uap.Models.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import saf.bienes_servicios_uap.Models.Dao.SubFuncionalidadDao;
import saf.bienes_servicios_uap.Models.Entity.SubFuncionalidad;

@Service
public class SubFuncionalidadServiceImpl implements ISubFuncionalidadService{

    @Autowired
    private SubFuncionalidadDao subFuncionalidadDao;

    @Override
    public List<SubFuncionalidad> findAll() {
        // TODO Auto-generated method stub
        return (List<SubFuncionalidad>) subFuncionalidadDao.findAll();
    }

    @Override
    public void save(SubFuncionalidad subFuncionalidad) {
        // TODO Auto-generated method stub
        subFuncionalidadDao.save(subFuncionalidad);
    }

    @Override
    public SubFuncionalidad findOne(Long id) {
        // TODO Auto-generated method stub
        return subFuncionalidadDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        subFuncionalidadDao.deleteById(id);
    }

    
}

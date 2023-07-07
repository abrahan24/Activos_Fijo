package saf.bienes_servicios_uap.Models.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import saf.bienes_servicios_uap.Models.Dao.UnidadFuncionalDao;
import saf.bienes_servicios_uap.Models.Entity.UnidadFuncional;

@Service
public class UnidadFuncionalServiceImpl implements IUnidadFuncionalService{

    @Autowired
    private UnidadFuncionalDao unidadFuncionalDao;

    @Override
    public List<UnidadFuncional> findAll() {
        // TODO Auto-generated method stub
        return (List<UnidadFuncional>) unidadFuncionalDao.findAll();
    }

    @Override
    public void save(UnidadFuncional unidadFuncional) {
        // TODO Auto-generated method stub
        unidadFuncionalDao.save(unidadFuncional);
    }

    @Override
    public UnidadFuncional findOne(Long id) {
        // TODO Auto-generated method stub
        return unidadFuncionalDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        unidadFuncionalDao.deleteById(id);
    }
    
}

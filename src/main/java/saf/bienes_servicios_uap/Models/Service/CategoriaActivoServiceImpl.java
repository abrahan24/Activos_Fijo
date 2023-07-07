package saf.bienes_servicios_uap.Models.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import saf.bienes_servicios_uap.Models.Dao.CategoriaActivoDao;
import saf.bienes_servicios_uap.Models.Entity.CategoriaActivo;

@Service
public class CategoriaActivoServiceImpl implements ICategoriaActivoService{

    @Autowired
    private CategoriaActivoDao categoriaActivoDao;

    @Override
    public List<CategoriaActivo> findAll() {
        // TODO Auto-generated method stub
        return (List<CategoriaActivo>) categoriaActivoDao.findAll();
    }

    @Override
    public void save(CategoriaActivo categoriaActivo) {
        // TODO Auto-generated method stub
        categoriaActivoDao.save(categoriaActivo);
    }

    @Override
    public CategoriaActivo findOne(Long id) {
        // TODO Auto-generated method stub
        return categoriaActivoDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        categoriaActivoDao.deleteById(id);
    }
    
}

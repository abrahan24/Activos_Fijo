package saf.bienes_servicios_uap.Models.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import saf.bienes_servicios_uap.Models.Dao.MarcaDao;
import saf.bienes_servicios_uap.Models.Entity.Marca;

@Service
public class MarcaServiceImpl implements IMarcaService{

    @Autowired
    private MarcaDao marcaDao;

    @Override
    public List<Marca> findAll() {
        // TODO Auto-generated method stub
        return (List<Marca>) marcaDao.findAll();
    }

    @Override
    public void save(Marca marca) {
        // TODO Auto-generated method stub
        marcaDao.save(marca);
    }

    @Override
    public Marca findOne(Long id) {
        // TODO Auto-generated method stub
        return marcaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        marcaDao.deleteById(id);
    }
    
}

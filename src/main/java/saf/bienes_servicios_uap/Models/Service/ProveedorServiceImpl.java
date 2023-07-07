package saf.bienes_servicios_uap.Models.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import saf.bienes_servicios_uap.Models.Dao.ProveedorDao;
import saf.bienes_servicios_uap.Models.Entity.Proveedor;

@Service
public class ProveedorServiceImpl implements IProveedorService{

    @Autowired
    private ProveedorDao proveedorDao;

    @Override
    public List<Proveedor> findAll() {
        // TODO Auto-generated method stub
        return (List<Proveedor>) proveedorDao.findAll();
    }

    @Override
    public void save(Proveedor proveedor) {
        // TODO Auto-generated method stub
        proveedorDao.save(proveedor);
    }

    @Override
    public Proveedor findOne(Long id) {
        // TODO Auto-generated method stub
        return proveedorDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        proveedorDao.deleteById(id);
    }
    
}

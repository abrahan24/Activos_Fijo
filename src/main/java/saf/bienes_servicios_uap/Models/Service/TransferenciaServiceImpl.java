package saf.bienes_servicios_uap.Models.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import saf.bienes_servicios_uap.Models.Dao.TransferenciaDao;
import saf.bienes_servicios_uap.Models.Entity.Transferencia;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService{

    @Autowired
    private TransferenciaDao transferenciaDao;

    @Override
    public List<Transferencia> findAll() {
        // TODO Auto-generated method stub
        return (List<Transferencia>) transferenciaDao.findAll();
    }

    @Override
    public void save(Transferencia transferencia) {
        // TODO Auto-generated method stub
        transferenciaDao.save(transferencia);
    }

    @Override
    public Transferencia findOne(Long id) {
        // TODO Auto-generated method stub
        return transferenciaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        transferenciaDao.deleteById(id);
    }
    
}

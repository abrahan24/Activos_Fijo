package saf.bienes_servicios_uap.Models.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import saf.bienes_servicios_uap.Models.Dao.DetalleTransferenciaDao;
import saf.bienes_servicios_uap.Models.Entity.DetalleTransferencia;

@Service
public class DetalleTransferenciaServiceImpl implements IDetalleTransferenciaService{


    @Autowired
    private DetalleTransferenciaDao detalleTransferenciaDao;

    @Override
    public List<DetalleTransferencia> findAll() {
        // TODO Auto-generated method stub
        return (List<DetalleTransferencia>) detalleTransferenciaDao.findAll();
    }

    @Override
    public void save(DetalleTransferencia detalleTransferencia) {
        // TODO Auto-generated method stub
        detalleTransferenciaDao.save(detalleTransferencia);
    }

    @Override
    public DetalleTransferencia findOne(Long id) {
        // TODO Auto-generated method stub
        return detalleTransferenciaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        detalleTransferenciaDao.deleteById(id);
    }
    
}

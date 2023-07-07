package saf.bienes_servicios_uap.Models.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import saf.bienes_servicios_uap.Models.Dao.DetalleBajaDao;
import saf.bienes_servicios_uap.Models.Entity.DetalleBaja;

@Service
public class DetalleBajaServiceImpl implements IDetalleBajaService{

    @Autowired
    private DetalleBajaDao detalleBajaDao;

    @Override
    public List<DetalleBaja> findAll() {
        // TODO Auto-generated method stub
        return (List<DetalleBaja>) detalleBajaDao.findAll();
    }

    @Override
    public void save(DetalleBaja detalleBaja) {
        // TODO Auto-generated method stub
        detalleBajaDao.save(detalleBaja);
    }

    @Override
    public DetalleBaja findOne(Long id) {
        // TODO Auto-generated method stub
        return detalleBajaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        detalleBajaDao.deleteById(id);
    }
    
}

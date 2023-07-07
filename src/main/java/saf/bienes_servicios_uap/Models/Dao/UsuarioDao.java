package saf.bienes_servicios_uap.Models.Dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import saf.bienes_servicios_uap.Models.Entity.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario ,Long>{
    
    @Query("select us from Usuario us where us.nom_usuario=?1 and us.contrasena=?2")
    public Usuario getUsuario(String nom_usuario,String contrasena);
}

package saf.bienes_servicios_uap.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import saf.bienes_servicios_uap.Models.Entity.Usuario;
import saf.bienes_servicios_uap.Models.Service.IPersonaService;
import saf.bienes_servicios_uap.Models.Service.IRolService;
import saf.bienes_servicios_uap.Models.Service.IUsuarioService;

@Controller
@RequestMapping("/SAF-UAP")
public class UsuarioController {

    private final JdbcTemplate jdbcTemplate;
    
    public UsuarioController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IRolService rolService;

    @Autowired
    private IPersonaService personaService;

    @GetMapping("/add_usuario")
    public String Vista_Usuario(Model model,RedirectAttributes flash, HttpServletRequest request,
    @RequestParam(name = "success",required = false)String success){

        if (request.getSession().getAttribute("usuario") != null) {
            
            if (success != null) {
                model.addAttribute("success", success);
            }

            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            usuario = usuarioService.findOne(usuario.getId_usuario());
            model.addAttribute("usuario", usuario);
            model.addAttribute("u", new Usuario());
            model.addAttribute("roles", rolService.findAll());
            model.addAttribute("personas", personaService.findAll());

            return "Registros/Registro_Usuario";
        } else {

            return "redirect:/SAF/Login";
        }
    }

    @RequestMapping(value = "/form_usuario",method = RequestMethod.POST)
    public String Form_Usuario(@Validated Usuario u,
    @RequestParam(name = "id_rol",required = false)Long id_rol,
    @RequestParam(name = "id_persona",required = false)Long id_persona,
    Model model,RedirectAttributes flash, HttpServletRequest request){

        if (request.getSession().getAttribute("usuario") != null) {
           
            jdbcTemplate.execute("CALL Registrar_Usuario(?, ?, ?, ?)", 
            (PreparedStatementCallback<Usuario>) ps -> {
                ps.setString(1, u.getNom_usuario());    
                ps.setString(2, u.getContrasena());
                ps.setLong(3, id_persona);
                ps.setLong(4, id_rol);
                ps.execute();
                return null;
            });

            flash.addAttribute("success", "Se Agrego un Nuevo Registro de Usuario Exitosamente!");
            return "redirect:/SAF-UAP/add_usuario";
        } else {

            return "redirect:/SAF/Login";
        }
    }

}

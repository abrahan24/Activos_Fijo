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
import saf.bienes_servicios_uap.Models.Entity.Activo;
import saf.bienes_servicios_uap.Models.Entity.Persona;
import saf.bienes_servicios_uap.Models.Entity.Usuario;
import saf.bienes_servicios_uap.Models.Service.IActivoService;
import saf.bienes_servicios_uap.Models.Service.ICategoriaActivoService;
import saf.bienes_servicios_uap.Models.Service.ITipoActivoService;
import saf.bienes_servicios_uap.Models.Service.IUsuarioService;


@Controller
@RequestMapping("/SAF-UAP")
public class ActivoController {

    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    public ActivoController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    private IUsuarioService usuarioService;
    
    @Autowired
    private IActivoService activoService;

    @Autowired
    private ITipoActivoService tipoActivoService;

    @Autowired
    private ICategoriaActivoService categoriaActivoService;

    
    @GetMapping("/add_activo")
    public String Vista_Persona(Model model,RedirectAttributes flash, HttpServletRequest request,
    @RequestParam(name = "success",required = false)String success){

        if (request.getSession().getAttribute("usuario") != null) {
            
            if (success != null) {
                model.addAttribute("success", success);
            }

            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            usuario = usuarioService.findOne(usuario.getId_usuario());

            model.addAttribute("usuario", usuario);
            model.addAttribute("activo", new Activo());
            model.addAttribute("tiposActivos", tipoActivoService.findAll());
            model.addAttribute("categoriasActivos", categoriaActivoService.findAll());
            

            return "Registros/Registro_Activo";
        } else {

            return "redirect:/SAF/Login";
        }
    }

    @RequestMapping(value = "/form_activo",method = RequestMethod.POST)
    public String Form_Persona(@Validated Persona persona,
    @RequestParam(name = "id_cargo",required = false)Long id_cargo,
    @RequestParam(name = "id_tipoPersonal",required = false)Long id_tipoPersonal,
    @RequestParam(name = "id_oficina",required = false)Long id_oficina,
    Model model,RedirectAttributes flash, HttpServletRequest request){

        if (request.getSession().getAttribute("usuario") != null) {

            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            usuario = usuarioService.findOne(usuario.getId_usuario());

           
            jdbcTemplate.execute("CALL Registrar_Persona(?, ?, ?, ?, ?, ?, ?, ?, ?)", 
            (PreparedStatementCallback<Activo>) ps -> {
                ps.setString(1, persona.getNom_persona());    
                ps.setString(2, persona.getAp_paterno());
                ps.setString(3, persona.getAp_materno());
                ps.setString(4, persona.getCi());
                ps.setString(5, persona.getCelular());
                ps.setLong(6, id_cargo);
                ps.setLong(7, id_oficina);
                ps.setLong(8, id_tipoPersonal);
                ps.execute();
                return null;
            });

            flash.addAttribute("success", "Se Agrego un Nuevo Registro de Activo Exitosamente!");
            return "redirect:/SAF-UAP/add_activo";
        } else {

            return "redirect:/SAF/Login";
        }
    }
}

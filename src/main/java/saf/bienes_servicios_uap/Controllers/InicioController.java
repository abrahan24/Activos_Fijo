package saf.bienes_servicios_uap.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import saf.bienes_servicios_uap.Models.Entity.Persona;
import saf.bienes_servicios_uap.Models.Entity.Usuario;
import saf.bienes_servicios_uap.Models.Service.IPersonaService;
import saf.bienes_servicios_uap.Models.Service.IUsuarioService;

@Controller
@RequestMapping("/SAF-UAP")
public class InicioController {

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired 
    private IPersonaService personaService;

    @GetMapping("/Inicio")
    public String Inicio (Model model,RedirectAttributes flash, HttpServletRequest request){


        if (request.getSession().getAttribute("usuario") != null) {
            
            Persona persona = (Persona) request.getSession().getAttribute("persona");
            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

            usuario = usuarioService.findOne(usuario.getId_usuario());
            persona = personaService.findOne(persona.getId_persona());

            model.addAttribute("usuario", usuario);

            return "Inicio/INICIO";
        } else {

            return "redirect:/SAF/Login";
        }

    }

    @RequestMapping("/cerrar_sesion")
    public String cerrarSesion(HttpServletRequest request, RedirectAttributes flash){
        HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
			flash.addAttribute("validado", "Se cerro sesion con exito!");
		}
		return "redirect:/SAF/Login";
    }

}

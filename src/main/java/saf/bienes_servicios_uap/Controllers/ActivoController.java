package saf.bienes_servicios_uap.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import saf.bienes_servicios_uap.Models.Entity.Persona;
import saf.bienes_servicios_uap.Models.Entity.Usuario;
import saf.bienes_servicios_uap.Models.Service.IActivoService;


@Controller
public class ActivoController {
    
    @Autowired
    private IActivoService activoService;

    
/* 

     @GetMapping("/add_persona")
    public String Vista_Persona(Model model,RedirectAttributes flash, HttpServletRequest request,
    @RequestParam(name = "success",required = false)String success){

        if (request.getSession().getAttribute("usuario") != null) {
            
            if (success != null) {
                model.addAttribute("success", success);
            }

            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            usuario = usuarioService.findOne(usuario.getId_usuario());


            

            return "Registros/Registro_Activo";
        } else {

            return "redirect:/SAF/Login";
        }
    } */
}

package saf.bienes_servicios_uap.Controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import saf.bienes_servicios_uap.Models.Entity.Predio;
import saf.bienes_servicios_uap.Models.Entity.Usuario;
import saf.bienes_servicios_uap.Models.Service.IPredioService;
import saf.bienes_servicios_uap.Models.Service.IUsuarioService;

@Controller
@RequestMapping("/SAF-UAP")
public class PredioController {
    
    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IPredioService predioService;

    @GetMapping("/add_predio")
    public String Vista_Predio(Model model,RedirectAttributes flash, HttpServletRequest request,
    @RequestParam(name = "success",required = false)String success){

        if (request.getSession().getAttribute("usuario") != null) {
            
            if (success != null) {
                model.addAttribute("success", success);
            }

            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            usuario = usuarioService.findOne(usuario.getId_usuario());
            model.addAttribute("usuario", usuario);
            model.addAttribute("predio", new Predio());

            return "Registros/Registro_Predio";
        } else {

            return "redirect:/SAF/Login";
        }
    }

    @RequestMapping(value = "/form_predio",method = RequestMethod.POST)
    public String Form_Predio(@Validated Predio predio,
    Model model,RedirectAttributes flash, HttpServletRequest request){

        if (request.getSession().getAttribute("usuario") != null) {
           
            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            usuario = usuarioService.findOne(usuario.getId_usuario());

            predio.setEstado_predio("A");
            predio.setFecha_reg_pre(new Date());
            predio.setUsuario_reg_pre(usuario.getId_usuario().intValue());
            predioService.save(predio);

            flash.addAttribute("success", "Se Agrego un Nuevo Registro de Predio Exitosamente!");
            return "redirect:/SAF-UAP/add_predio";
        } else {

            return "redirect:/SAF/Login";
        }
    }
}

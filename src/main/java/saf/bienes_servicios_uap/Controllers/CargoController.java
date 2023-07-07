package saf.bienes_servicios_uap.Controllers;

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
import saf.bienes_servicios_uap.Models.Entity.Cargo;
import saf.bienes_servicios_uap.Models.Entity.Usuario;
import saf.bienes_servicios_uap.Models.Service.ICargoService;
import saf.bienes_servicios_uap.Models.Service.IUsuarioService;

@Controller
@RequestMapping("/SAF-UAP")
public class CargoController {
    
    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private ICargoService cargoService;

    @GetMapping("/add_cargo")
    public String Vista_Cargo(Model model,RedirectAttributes flash, HttpServletRequest request,
    @RequestParam(name = "success",required = false)String success){

        if (request.getSession().getAttribute("usuario") != null) {
            
            if (success != null) {
                model.addAttribute("success", success);
            }

            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            usuario = usuarioService.findOne(usuario.getId_usuario());
            model.addAttribute("usuario", usuario);
            model.addAttribute("cargo", new Cargo());

            return "Registros/Registro_Cargo";
        } else {

            return "redirect:/SAF/Login";
        }
    }

    @RequestMapping(value = "/form_cargo",method = RequestMethod.POST)
    public String Form_Cargo(@Validated Cargo cargo,
    Model model,RedirectAttributes flash, HttpServletRequest request){

        if (request.getSession().getAttribute("usuario") != null) {
           
            cargo.setEstado_cargo("A");
            cargoService.save(cargo);

            flash.addAttribute("success", "Se Agrego un Nuevo Registro de Cargo Exitosamente!");
            return "redirect:/SAF-UAP/add_cargo";
        } else {

            return "redirect:/SAF/Login";
        }
    }
}

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
import saf.bienes_servicios_uap.Models.Entity.TipoPersonal;
import saf.bienes_servicios_uap.Models.Entity.Usuario;
import saf.bienes_servicios_uap.Models.Service.ITipoPersonalService;
import saf.bienes_servicios_uap.Models.Service.IUsuarioService;

@Controller
@RequestMapping("/SAF-UAP")
public class TipoPersonalController {
    
    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private ITipoPersonalService tipoPersonalService;

    @GetMapping("/add_tipopersonal")
    public String Vista_TipoPersonal(Model model,RedirectAttributes flash, HttpServletRequest request,
    @RequestParam(name = "success",required = false)String success){

        if (request.getSession().getAttribute("usuario") != null) {
            
            if (success != null) {
                model.addAttribute("success", success);
            }

            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            usuario = usuarioService.findOne(usuario.getId_usuario());
            model.addAttribute("usuario", usuario);
            model.addAttribute("tipopersonal", new TipoPersonal());

            return "Registros/Registro_TipoPersonal";
        } else {

            return "redirect:/SAF/Login";
        }
    }

    @RequestMapping(value = "/form_tipopersonal",method = RequestMethod.POST)
    public String Form_TipoPersonal(@Validated TipoPersonal tipoPersonal,Model model,RedirectAttributes flash, HttpServletRequest request){

        if (request.getSession().getAttribute("usuario") != null) {
           
            tipoPersonal.setEstado_tipoPersonal("A");
            tipoPersonalService.save(tipoPersonal);

            flash.addAttribute("success", "Se Agrego un Nuevo Registro de Tipo Personal Exitosamente!");
            return "redirect:/SAF-UAP/add_tipopersonal";
        } else {

            return "redirect:/SAF/Login";
        }
    }
}

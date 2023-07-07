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
import saf.bienes_servicios_uap.Models.Entity.Oficina;
import saf.bienes_servicios_uap.Models.Entity.Usuario;
import saf.bienes_servicios_uap.Models.Service.IOficinaService;
import saf.bienes_servicios_uap.Models.Service.IUnidadFuncionalService;
import saf.bienes_servicios_uap.Models.Service.IUsuarioService;

@Controller
@RequestMapping("/SAF-UAP")
public class OficinaController {
    
    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IOficinaService oficinaService;

    @Autowired
    private IUnidadFuncionalService unidadFuncionalService;

    @GetMapping("/add_oficina")
    public String Vista_Oficina(Model model,RedirectAttributes flash, HttpServletRequest request,
    @RequestParam(name = "success",required = false)String success){

        if (request.getSession().getAttribute("usuario") != null) {
            
            if (success != null) {
                model.addAttribute("success", success);
            }

            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            usuario = usuarioService.findOne(usuario.getId_usuario());
            model.addAttribute("usuario", usuario);
            model.addAttribute("oficina", new Oficina());
            model.addAttribute("unidad_funcionales", unidadFuncionalService.findAll());

            return "Registros/Registro_Oficina";
        } else {

            return "redirect:/SAF/Login";
        }
    }

    @RequestMapping(value = "/form_oficina",method = RequestMethod.POST)
    public String Form_Oficina(@Validated Oficina oficina,Model model,
    @RequestParam(name = "id_unidadFuncional")Long id_unidadFuncional,RedirectAttributes flash, HttpServletRequest request){

        if (request.getSession().getAttribute("usuario") != null) {
           
            oficina.setEstado_oficina("A");
            oficina.setUnidadFuncional(unidadFuncionalService.findOne(id_unidadFuncional));
            oficinaService.save(oficina);

            flash.addAttribute("success", "Se Agrego Un Nuevo Registro de Oficina Exitosamente!");
            return "redirect:/SAF-UAP/add_oficina";
        } else {

            return "redirect:/SAF/Login";
        }
    }
}

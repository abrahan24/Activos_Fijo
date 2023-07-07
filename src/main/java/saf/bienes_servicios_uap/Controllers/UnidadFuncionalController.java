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
import saf.bienes_servicios_uap.Models.Entity.UnidadFuncional;
import saf.bienes_servicios_uap.Models.Entity.Usuario;
import saf.bienes_servicios_uap.Models.Service.IPredioService;
import saf.bienes_servicios_uap.Models.Service.IUnidadFuncionalService;
import saf.bienes_servicios_uap.Models.Service.IUsuarioService;

@Controller
@RequestMapping("/SAF-UAP")
public class UnidadFuncionalController {
    
    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IPredioService predioService;

    @Autowired
    private IUnidadFuncionalService unidadFuncionalService;

    @GetMapping("/add_unidadfuncional")
    public String Vista_UnidadFuncional(Model model,RedirectAttributes flash, HttpServletRequest request,
    @RequestParam(name = "success",required = false)String success){

        if (request.getSession().getAttribute("usuario") != null) {
            
            if (success != null) {
                model.addAttribute("success", success);
            }

            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            usuario = usuarioService.findOne(usuario.getId_usuario());
            model.addAttribute("usuario", usuario);
            model.addAttribute("unidadFuncional", new UnidadFuncional());
            model.addAttribute("predios", predioService.findAll());

            return "Registros/Registro_UnidadFuncional";
        } else {

            return "redirect:/SAF/Login";
        }
    }

    @RequestMapping(value = "/form_unidadfuncional",method = RequestMethod.POST)
    public String Form_UnidadFuncional(@Validated UnidadFuncional unidadFuncional,
    @RequestParam(name = "id_predio",required = false)Long id_predio,
    Model model,RedirectAttributes flash, HttpServletRequest request){

        if (request.getSession().getAttribute("usuario") != null) {
           
            unidadFuncional.setEstado_unidad("A");
            unidadFuncional.setPredio(predioService.findOne(id_predio));
            unidadFuncionalService.save(unidadFuncional);

            flash.addAttribute("success", "Se Agrego un Nuevo Registro de Unidad Funcional Exitosamente!");
            return "redirect:/SAF-UAP/add_unidadfuncional";
        } else {

            return "redirect:/SAF/Login";
        }
    }
}

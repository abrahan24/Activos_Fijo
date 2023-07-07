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
import saf.bienes_servicios_uap.Models.Entity.SubFuncionalidad;
import saf.bienes_servicios_uap.Models.Entity.Usuario;
import saf.bienes_servicios_uap.Models.Service.IFuncionalidadService;
import saf.bienes_servicios_uap.Models.Service.ISubFuncionalidadService;
import saf.bienes_servicios_uap.Models.Service.IUsuarioService;

@Controller
@RequestMapping("/SAF-UAP")
public class SubFuncionalidadController {
    
    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IFuncionalidadService funcionalidadService;

    @Autowired
    private ISubFuncionalidadService subFuncionalidadService;

    @GetMapping("/add_subfuncionalidad")
    public String Vista_SubFuncionalidad(Model model,RedirectAttributes flash, HttpServletRequest request,
    @RequestParam(name = "success",required = false)String success){

        if (request.getSession().getAttribute("usuario") != null) {
            
            if (success != null) {
                model.addAttribute("success", success);
            }

            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            usuario = usuarioService.findOne(usuario.getId_usuario());
            model.addAttribute("usuario", usuario);
            model.addAttribute("subfun", new SubFuncionalidad());
            model.addAttribute("funcionalidades", funcionalidadService.findAll());

            return "Registros/Registro_Funcionalidad";
        } else {

            return "redirect:/SAF/Login";
        }
    }

    @RequestMapping(value = "/form_subfuncionalidad",method = RequestMethod.POST)
    public String Form_SubFuncionalidad(@Validated SubFuncionalidad subFuncionalidad,
    @RequestParam(name = "id_funcionalidad",required = false)Long id_funcionalidad,
    Model model,RedirectAttributes flash, HttpServletRequest request){

        if (request.getSession().getAttribute("usuario") != null) {
           
            subFuncionalidad.setEstado_subFun("A");
            subFuncionalidad.setFuncionalidad(funcionalidadService.findOne(id_funcionalidad));
            subFuncionalidadService.save(subFuncionalidad);

            flash.addAttribute("success", "Se Agrego un Nuevo Registro de SubFuncionalidad Exitosamente!");
            return "redirect:/SAF-UAP/add_subfuncionalidad";
        } else {

            return "redirect:/SAF/Login";
        }
    }
}

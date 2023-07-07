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
import saf.bienes_servicios_uap.Models.Entity.Funcionalidad;
import saf.bienes_servicios_uap.Models.Entity.Usuario;
import saf.bienes_servicios_uap.Models.Service.IFuncionalidadService;
import saf.bienes_servicios_uap.Models.Service.IRolService;
import saf.bienes_servicios_uap.Models.Service.IUsuarioService;

@Controller
@RequestMapping("/SAF-UAP")
public class FuncionalidadController {
    
    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IFuncionalidadService funcionalidadService;

    @Autowired
    private IRolService rolService;

    @GetMapping("/add_funcionalidad")
    public String Vista_Funcionalidad(Model model,RedirectAttributes flash, HttpServletRequest request,
    @RequestParam(name = "success",required = false)String success){

        if (request.getSession().getAttribute("usuario") != null) {
            
            if (success != null) {
                model.addAttribute("success", success);
            }

            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            usuario = usuarioService.findOne(usuario.getId_usuario());
            model.addAttribute("usuario", usuario);
            model.addAttribute("funcionalidad", new Funcionalidad());

            return "Registros/Registro_Funcionalidad";
        } else {

            return "redirect:/SAF/Login";
        }
    }

    @RequestMapping(value = "/form_funcionalidad",method = RequestMethod.POST)
    public String Form_Funcionalidad(@Validated Funcionalidad funcionalidad,
    @RequestParam(name = "id_rol",required = false)Long id_rol,
    Model model,RedirectAttributes flash, HttpServletRequest request){

        if (request.getSession().getAttribute("usuario") != null) {
           
            funcionalidad.setEstado_funcionalidad("A");
            funcionalidad.setRol(rolService.findOne(id_rol));
            funcionalidadService.save(funcionalidad);

            flash.addAttribute("success", "Se Agrego un Nuevo Registro de Funcionalidad Exitosamente!");
            return "redirect:/SAF-UAP/add_funcionalidad";
        } else {

            return "redirect:/SAF/Login";
        }
    }
}

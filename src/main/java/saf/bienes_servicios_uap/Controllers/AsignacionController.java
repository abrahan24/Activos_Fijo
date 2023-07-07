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
import saf.bienes_servicios_uap.Models.Entity.Activo;
import saf.bienes_servicios_uap.Models.Entity.Asignacion;
import saf.bienes_servicios_uap.Models.Entity.DetalleAsignacion;
import saf.bienes_servicios_uap.Models.Entity.Persona;
import saf.bienes_servicios_uap.Models.Entity.Usuario;
import saf.bienes_servicios_uap.Models.Service.IActivoService;
import saf.bienes_servicios_uap.Models.Service.IAsignacionService;
import saf.bienes_servicios_uap.Models.Service.IDetalleAsignacionService;
import saf.bienes_servicios_uap.Models.Service.IPersonaService;
import saf.bienes_servicios_uap.Models.Service.IUsuarioService;


@Controller
@RequestMapping("/SAF-UAP")
public class AsignacionController {
    
    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IPersonaService personaService;

    @Autowired
    private IActivoService activoService;

    @Autowired
    private IAsignacionService asignacionService;

    @Autowired
    private IDetalleAsignacionService detalleAsignacionService;


    @GetMapping("/add_asignacion")
    public String Vista_Asignacion(Model model,RedirectAttributes flash, HttpServletRequest request,
    @RequestParam(name = "success",required = false)String success){

        if (request.getSession().getAttribute("usuario") != null) {
            
            if (success != null) {
                model.addAttribute("success", success);
            }

            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            usuario = usuarioService.findOne(usuario.getId_usuario());
            model.addAttribute("usuario", usuario);
            model.addAttribute("activos", activoService.findAll());
            model.addAttribute("personas", personaService.findAll());
            model.addAttribute("asignacion", new Asignacion());

            return "Inicio/ASIGNACION";
        } else {

            return "redirect:/SAF/Login";
        }
    }

    @RequestMapping(value = "/form_asignacion",method = RequestMethod.POST)
    public String Form_Asginacion_Activos(@Validated Asignacion asignacion,
    @RequestParam(name = "id_usuario",required = false)Long id_usuario,
    @RequestParam(name = "id_persona",required = false)Long id_persona,
    @RequestParam(name = "id_activo",required = false)Long [] id_activo,
    Model model,RedirectAttributes flash, HttpServletRequest request){
         if (request.getSession().getAttribute("usuario") != null) {

            asignacion.setEstado_asignacion("A");
            asignacion.setFecha_asignacion(new Date());
            asignacion.setFecha_reg_a(new Date());
            asignacion.setPersona(personaService.findOne(id_persona));
            Persona persona = personaService.findOne(id_persona);
            persona.setEstado_persona("PA");    //PA = Persona Asignada
            asignacion.setUsuario(usuarioService.findOne(id_usuario));
            asignacionService.save(asignacion);

            if (id_activo != null) {
                for (int i = 0; i < id_activo.length; i++) {
                DetalleAsignacion detalleAsignacion = new DetalleAsignacion();

                detalleAsignacion.setEstado_detalleAsignacion("A");
                detalleAsignacion.setActivo(activoService.findOne(id_activo[i]));
                detalleAsignacion.setAsignacion(asignacionService.findOne(asignacion.getId_asignacion()));
                detalleAsignacion.setFecha_reg_det_a(new Date());
                detalleAsignacion.setUsuario_reg_det_a(id_usuario.intValue());
                detalleAsignacionService.save(detalleAsignacion);

                Activo activo = activoService.findOne(id_activo[i]);
                activo.setEstado_activo("AA"); // AA = Activo Asignado a Una Persona
                activoService.save(activo);
            }
            }
            
            flash.addAttribute("success", "Se Realizo la Asignacion de Activos Exitosamente!");
            return "redirect:/SAF-UAP/add_asignacion";
        } else {

            return "redirect:/SAF/Login";
        }
    }
}

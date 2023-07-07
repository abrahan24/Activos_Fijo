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
import saf.bienes_servicios_uap.Models.Entity.DetalleTransferencia;
import saf.bienes_servicios_uap.Models.Entity.Persona;
import saf.bienes_servicios_uap.Models.Entity.Transferencia;
import saf.bienes_servicios_uap.Models.Entity.Usuario;
import saf.bienes_servicios_uap.Models.Service.IActivoService;
import saf.bienes_servicios_uap.Models.Service.IAsignacionService;
import saf.bienes_servicios_uap.Models.Service.IDetalleTransferenciaService;
import saf.bienes_servicios_uap.Models.Service.IPersonaService;
import saf.bienes_servicios_uap.Models.Service.ITransferenciaService;
import saf.bienes_servicios_uap.Models.Service.IUsuarioService;

@Controller
@RequestMapping("/SAF-UAP")
public class TransferenciaController {
    
    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private ITransferenciaService transferenciaService;

    @Autowired
    private IPersonaService personaService;

    @Autowired
    private IAsignacionService asignacionService;

    @Autowired
    private IDetalleTransferenciaService detalleTransferenciaService;

    @Autowired
    private IActivoService activoService;


    @GetMapping("/buscar_asignacion_ci")
    public String Vista_Buscar_Asignacion_CI(Model model,RedirectAttributes flash, HttpServletRequest request,
    @RequestParam(name = "success",required = false)String success){

        if (request.getSession().getAttribute("usuario") != null) {
            
            if (success != null) {
                model.addAttribute("success", success);
            }

            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            usuario = usuarioService.findOne(usuario.getId_usuario());
            model.addAttribute("usuario", usuario);

            return "Inicio/BUSCAR_PERSONA";
        } else {

            return "redirect:/SAF/Login";
        }
    }

    @RequestMapping(value = "/form_buscar_asignacion",method = RequestMethod.POST)
    public String Form_Buscar_Asignacion(@RequestParam(name = "ci",required = false)String ci,
    Model model,RedirectAttributes flash, HttpServletRequest request){
         if (request.getSession().getAttribute("usuario") != null) {

            Asignacion asignacion = asignacionService.Buscar_Asignacion_Ci_Persona(ci);
            if (asignacion != null) {
                Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
                usuario = usuarioService.findOne(usuario.getId_usuario());
                model.addAttribute("usuario", usuario);
                model.addAttribute("asignacion", asignacion);
                model.addAttribute("personas", personaService.findAll());
                model.addAttribute("transferencia", new Transferencia());
                return "Inicio/TRANSFERENCIA";
            }else{
                    
            flash.addAttribute("success", "No se Encontro Activos Asignados!");
            return "redirect:/SAF-UAP/buscar_asignacion_ci";
            }
            
        } else {

            return "redirect:/SAF/Login";
        }
    }

    @RequestMapping(value = "/form_transferencia",method = RequestMethod.POST)
    public String Form_Transferencia(@Validated Transferencia transferencia,
    @RequestParam(name = "id_persona",required = false)Long id_persona,
    @RequestParam(name = "id_usuario",required = false)Long id_usuario,
    @RequestParam(name = "id_activo",required = false)Long [] id_activo,
    @RequestParam(name = "id_asignacion",required = false)Long id_asignacion,
    Model model,RedirectAttributes flash, HttpServletRequest request){
         if (request.getSession().getAttribute("usuario") != null) {

            transferencia.setEstado_transferencia("A");
            transferencia.setFecha_transferencia(new Date());
            transferencia.setFecha_reg_t(new Date());
            transferencia.setPersona(personaService.findOne(id_persona));
            Asignacion  asignacion = asignacionService.findOne(id_asignacion);
            Persona persona = personaService.findOne(asignacion.getPersona().getId_persona());
            persona.setEstado_persona("A");
            personaService.save(persona);
            asignacion.setPersona(personaService.findOne(id_persona));
            asignacionService.save(asignacion);
            Persona persona2 = personaService.findOne(id_persona);
            persona2.setEstado_persona("PA");
            personaService.save(persona2);
            transferenciaService.save(transferencia);

            if (id_activo != null) {
                for (int i = 0; i < id_activo.length; i++) {
                    DetalleTransferencia detalleTransferencia = new DetalleTransferencia();
                    detalleTransferencia.setEstado_detalleTrans("A");
                    detalleTransferencia.setFecha_detalleTrans(new Date());
                    detalleTransferencia.setActivo(activoService.findOne(id_activo[i]));
                    detalleTransferencia.setTransferencia(transferenciaService.findOne(transferencia.getId_transferencia()));
                    detalleTransferencia.setFecha_reg_det_t(new Date());
                    detalleTransferencia.setUsuario_reg_det_t(id_usuario.intValue());
                    detalleTransferenciaService.save(detalleTransferencia);

                    Activo activo = activoService.findOne(id_activo[i]);
                    activo.setEstado_activo("AT");
                    activoService.save(activo);
                }
            }
            
            flash.addAttribute("success", "Se Realizo la Transferencia de Activos Exitosamente!");
            return "redirect:/SAF-UAP/buscar_asignacion_ci";
        } else {

            return "redirect:/SAF/Login";
        }
    }
}

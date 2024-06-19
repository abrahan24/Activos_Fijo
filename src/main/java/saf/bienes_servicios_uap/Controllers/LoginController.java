package saf.bienes_servicios_uap.Controllers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import saf.bienes_servicios_uap.Models.Entity.Usuario;
import saf.bienes_servicios_uap.Models.Service.IUsuarioService;

@Controller
@RequestMapping("/SAF")
public class LoginController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/Login")
    public String login (Model model){

        return "Login/LOGIN";
    }

    @PostMapping("/Login_Form")
    public String login_Form(Model model,@RequestParam String nom_usuario,
        @RequestParam String contrasena,RedirectAttributes flash, HttpServletRequest request){
            
            // String contra_desencriptada = desencriptarContraseña(contrasena);
        Usuario usuario = usuarioService.getUsuario(nom_usuario, contrasena);

        model.addAttribute("usuario", usuario);
        if (usuario != null) {
            HttpSession session = request.getSession(false);

            session = request.getSession(true);
            session.setAttribute("persona", usuario.getPersona());
            session.setAttribute("usuario", usuario);
           
            return "redirect:/SAF-UAP/Inicio";
        } else {
            return "Login/LOGIN";
        }

    }

    public static String desencriptarContraseña(String contraseñaEncriptada) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(contraseñaEncriptada.getBytes());
            
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }   
}

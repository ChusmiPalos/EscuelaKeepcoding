package io.keepcoding.app.escuela.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.keepcoding.app.escuela.entity.Usuario;
import io.keepcoding.app.escuela.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping({"/","/login"})
	public String index() {
		return "login";
	}
	
	@PostMapping("/submitLogin")
	public String submitLogin(@RequestParam String usuarioBuscado, @RequestParam String passBuscado, Model model) {
		Usuario usuario = usuarioService.findByUsuarioAndPassword(usuarioBuscado, passBuscado);
		if (usuario != null) {
			return "redirect:/menu";
		}else {
			model.addAttribute("error", "Usuario o contraseña incorrectos");
			return "login";
		}
	}
	
	
	
//	public String loginUsuario(Model modelo, @Param("userLogin") String userLogin, @Param("passLogin") String passLogin) {
//		System.out.print(userLogin);
//		System.out.print(passLogin);
//		modelo.addAttribute("login", usuarioService.buscarUsuario(userLogin,passLogin));
//		return "login";
//	}
}

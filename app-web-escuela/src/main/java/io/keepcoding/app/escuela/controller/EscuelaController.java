package io.keepcoding.app.escuela.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import io.keepcoding.app.escuela.entity.Alumno;
import io.keepcoding.app.escuela.service.AlumnoService;

@Controller
public class EscuelaController {

	@Autowired
	private AlumnoService alumnoService;

	@GetMapping("/menu")
	public String index(Model modelo) {
		modelo.addAttribute("alumnos", alumnoService.listarAlumnos());
		return "menu";
	}

	@GetMapping("/alumno/new")
	public String newAlumnoForm(Model modelo) {
		Alumno alumno = new Alumno();
		modelo.addAttribute("alumno", alumno);
		return "crear_alumno";
	}

	@PostMapping("/alumnoForm")
	public String saveAlumno(@ModelAttribute("alumno") Alumno alumno) {
		alumnoService.guardarAlumno(alumno);
		return "redirect:/menu";
	}

	@GetMapping("/alumno/editar/{id}")
	public String updateAlumnoForm(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("alumno_update", alumnoService.obtenerAlumno(id));
		return "editar_alumno";
	}
	
	@PostMapping("/alumno/{id}")
	public String updateAlumno(@PathVariable Long id, @ModelAttribute("alumno_update") Alumno alumno) {
		Alumno alumnoExistente = alumnoService.obtenerAlumno(id);
		alumnoExistente.setId(id);
		alumnoExistente.setNombre(alumno.getNombre());
		alumnoExistente.setApellido(alumno.getApellido());
		alumnoExistente.setDni(alumno.getDni());
		alumnoExistente.setFecha_nac(alumno.getFecha_nac());
		alumnoExistente.setEmail(alumno.getEmail());
		alumnoExistente.setTelefono(alumno.getTelefono());
		
		alumnoService.actualizarAlumno(alumnoExistente);
		return "redirect:/menu";
	}
	
	@GetMapping("/alumno/delete/{id}")
	public String deleteAlumno(@PathVariable Long id) {
		alumnoService.eliminarAlumno(id);
		return "redirect:/menu";
	}
}

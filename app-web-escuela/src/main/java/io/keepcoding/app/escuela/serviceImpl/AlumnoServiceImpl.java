package io.keepcoding.app.escuela.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.keepcoding.app.escuela.entity.Alumno;
import io.keepcoding.app.escuela.repository.AlumnoRepository;
import io.keepcoding.app.escuela.service.AlumnoService;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	private AlumnoRepository alumnoRepository;

	@Override
	public List<Alumno> listarAlumnos() {
			return alumnoRepository.findAll();
		
	}

	@Override
	public Alumno guardarAlumno(Alumno alumno) {
		return alumnoRepository.save(alumno);
	}

	@Override
	public Alumno obtenerAlumno(Long id) {
		return alumnoRepository.findById(id).get();
	}

	@Override
	public Alumno actualizarAlumno(Alumno alumno) {
		return alumnoRepository.save(alumno);
	}

	@Override
	public void eliminarAlumno(Long id) {
		alumnoRepository.deleteById(id);

	}

}

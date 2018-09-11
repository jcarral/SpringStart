package com.jcarral.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jcarral.model.Empleado;
import com.jcarral.model.ErrorRest;
import com.jcarral.repo.EmpleadoRepo;

@RestController
@RequestMapping("/api")
public class EmpleadoController {
	
	@Autowired
	EmpleadoRepo empleadoRepository;
	
	@GetMapping("/list")
	public List<Empleado> list(){
		List<Empleado> listEmpleados = empleadoRepository.findAll();
		if (listEmpleados == null || listEmpleados.size() == 0) throw new EmpleadoNotFoundException();
		return listEmpleados;
	}
	
	@GetMapping("/empleado/{id}") 
	public Optional<Empleado> getEmpleado(@PathVariable Long id) {
		Optional<Empleado> result = empleadoRepository.findById(id);
	
		if (result.isPresent())
			return result;
		else
			throw new EmpleadoNotFoundException(id);
	}
	
	@PostMapping("/empleado")
	public Empleado createEmpleado(@RequestBody Empleado empleado, HttpServletResponse response) {
		Empleado nuevo = new Empleado(empleado.getNombre(), empleado.getApellidos(), empleado.getFechaNacimiento());
		response.setStatus(201);
		return empleadoRepository.save(nuevo);
	}
	
	@PostMapping("/empleado2")
	public ResponseEntity<?> createEmpleadoAlternative(RequestEntity<Empleado> request){
		if(request.getBody() == null) {
			return new ResponseEntity<ErrorRest>(new ErrorRest("Formato de la petición incorrecto"), HttpStatus.BAD_REQUEST);
		}
		Empleado empleado = request.getBody();
		System.out.println(request);
		if(!empleadoRepository.findById(empleado.getId()).isPresent()) {
			return new ResponseEntity<Empleado>(empleadoRepository.save(empleado), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<ErrorRest>(new ErrorRest("Empleado ya existente"), HttpStatus.CONFLICT);
		}
			
	}
	
	@PutMapping("empleado/{ip}")
	public ResponseEntity<?> updateEmpleado(@PathVariable Long id, RequestEntity<Empleado> request){
		if(!request.hasBody()) return new ResponseEntity<ErrorRest>(new ErrorRest("Formato de la petición incorrecto"), HttpStatus.BAD_REQUEST);
		if(empleadoRepository.findById(id).isPresent()) {
			Empleado oldEmp = request.getBody();
			Empleado nextEmp = new Empleado(id, oldEmp.getNombre(), oldEmp.getApellidos(), oldEmp.getFechaNacimiento());
			return new ResponseEntity<Empleado>(empleadoRepository.save(nextEmp), HttpStatus.OK);
		} else {
			return new ResponseEntity<ErrorRest>(new ErrorRest("El empleado no existe"), HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/empleado/{id}")
	public ResponseEntity<?> deleteEmpleado(@PathVariable Long id){
		if(empleadoRepository.findById(id).isPresent()) {
			Empleado oldEmp = empleadoRepository.findById(id).get();
			empleadoRepository.delete(oldEmp);
			return new ResponseEntity<Empleado>(oldEmp, HttpStatus.OK);
		} else {
			return new ResponseEntity<ErrorRest>(new ErrorRest("El empleado no existe"), HttpStatus.NOT_FOUND);
		}

	}
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	private class EmpleadoNotFoundException extends RuntimeException {

		/**
		 * 
		 */
		private static final long serialVersionUID = 2559759310207319794L;
		
		public EmpleadoNotFoundException() {
			super("No existe ningún empleado");
		}
		
		public EmpleadoNotFoundException(Long id) {
			super(String.format("No existe ningún empleado con el id = %d", id));
		}
	}
}

package com.clinica.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.clinica.exception.ModeloNotFoundException;
import com.clinica.model.Examen;
import com.clinica.model.Examen;
import com.clinica.service.IExamenService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/examenes")
public class ExamenController {

	@Autowired
	private IExamenService service;

	@GetMapping
	public ResponseEntity<List<Examen>> listar() throws Exception {
		List<Examen> lista = service.listar();
		return new ResponseEntity<List<Examen>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Examen> listarPorId(@PathVariable("id") Integer id) throws Exception {
		Examen obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		return new ResponseEntity<Examen>(obj, HttpStatus.OK);
	}

	// @ResponseStatus(HttpStatus.NOT_FOUND)
	@GetMapping("/hateoas/{id}")
	public EntityModel<Examen> listarPorIdHateoas(@PathVariable("id") Integer id) throws Exception {
		Examen obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		EntityModel<Examen> recurso = EntityModel.of(obj);

		// localhost:8080/Examenes/4
		WebMvcLinkBuilder link1 = linkTo(methodOn(this.getClass()).listarPorIdHateoas(id));
		WebMvcLinkBuilder link2 = linkTo(methodOn(this.getClass()).listarPorIdHateoas(id));

		recurso.add(link1.withRel("Examen-recurso1"));
		recurso.add(link2.withRel("Examen-recurso2"));

		return recurso;
	}

	/*
	 * @PostMapping public ResponseEntity<Examen> registrar(@Valid @RequestBody
	 * Examen p) throws Exception{ Examen obj = service.registrar(p); return new
	 * ResponseEntity<Examen>(obj, HttpStatus.CREATED); }
	 */

	@PostMapping
	public ResponseEntity<Examen> registrar(@Valid @RequestBody Examen p) throws Exception {

		Examen obj = service.registrar(p);

		// localhost:8080/Examens/2
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getIdExamen()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Examen> modificar(@Valid @RequestBody Examen p) throws Exception {
		Examen obj = service.modificar(p);
		return new ResponseEntity<Examen>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		Examen obj = service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}

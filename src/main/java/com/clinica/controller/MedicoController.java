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
import com.clinica.model.Medico;
import com.clinica.model.Medico;
import com.clinica.service.IMedicoService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

	@Autowired
	private IMedicoService service;

	@GetMapping
	public ResponseEntity<List<Medico>> listar() throws Exception {
		List<Medico> lista = service.listar();
		return new ResponseEntity<List<Medico>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Medico> listarPorId(@PathVariable("id") Integer id) throws Exception {
		Medico obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		return new ResponseEntity<Medico>(obj, HttpStatus.OK);
	}

	// @ResponseStatus(HttpStatus.NOT_FOUND)
	@GetMapping("/hateoas/{id}")
	public EntityModel<Medico> listarPorIdHateoas(@PathVariable("id") Integer id) throws Exception {
		Medico obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		EntityModel<Medico> recurso = EntityModel.of(obj);

		// localhost:8080/Medicos/4
		WebMvcLinkBuilder link1 = linkTo(methodOn(this.getClass()).listarPorIdHateoas(id));
		WebMvcLinkBuilder link2 = linkTo(methodOn(this.getClass()).listarPorIdHateoas(id));

		recurso.add(link1.withRel("Medico-recurso1"));
		recurso.add(link2.withRel("Medico-recurso2"));

		return recurso;
	}

	/*
	 * @PostMapping public ResponseEntity<Medico> registrar(@Valid @RequestBody
	 * Medico p) throws Exception{ Medico obj = service.registrar(p); return new
	 * ResponseEntity<Medico>(obj, HttpStatus.CREATED); }
	 */

	@PostMapping
	public ResponseEntity<Medico> registrar(@Valid @RequestBody Medico p) throws Exception {

		Medico obj = service.registrar(p);

		// localhost:8080/Medicos/2
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getIdMedico()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Medico> modificar(@Valid @RequestBody Medico p) throws Exception {
		Medico obj = service.modificar(p);
		return new ResponseEntity<Medico>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		Medico obj = service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}

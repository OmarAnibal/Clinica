package com.clinica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "especialidad")
public class Especialidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEspecialidad;
	
	@Column(name="nombre", nullable = false, length = 50)
	private String nombre;
	
	@Column(name="descripcion", nullable = true, length = 150)
	private String descripcion; 
}

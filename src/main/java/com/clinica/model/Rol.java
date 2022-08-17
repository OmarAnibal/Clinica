package com.clinica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name= "rol")
public class Rol {
	
	@Id
	private Integer idRol;
	
	@Column(name="nombre", nullable = false, length = 50)
	private String nombre;
	
	@Column(name="descripcion", nullable = true, length = 150)
	private String descripcion;
}

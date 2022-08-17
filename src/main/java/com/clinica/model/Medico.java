package com.clinica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity //(name="zzz") para asignar nombre a la entidad
@Table(name ="medico")
public class Medico {

	// JPQL Java Persistence Query Language
	// JPQL -> FROM zzz m WHERE m.idMedico = 1 --apunta a las entidades (tablas) para consultas mas robustas
	// SQL -> SELECT * FROM MEDICO m WHERE m.id_medico = 1 --apunta directamente a la base de datos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMedico;
	
	@Column(name="nombres", nullable = false, length = 70)
	private String nombres;
	
	@Column(name="apellidos", nullable = false, length = 70)
	private String apellidos;
	
	@Column(name="tarjetaProfesional", nullable = false, length = 12, unique = true)
	private String tarjetaProfesional;
	
	@Column(name="foto_url", nullable = true)
	private String fotoUrl; 
	
	
	
	
}

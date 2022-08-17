package com.clinica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "consulta_examen")
public class ConsultaExamen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_consulta_examen")
	private int id_consulta_examen;
	
	@ManyToOne
	@JoinColumn(name = "id_consulta")
	private Consulta consulta;
	
	@ManyToOne
	@JoinColumn(name = "id_examen")
	private Examen examen;
}

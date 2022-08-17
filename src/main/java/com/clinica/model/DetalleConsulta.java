package com.clinica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name ="detalle_consulta")
public class DetalleConsulta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDetalle;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_consulta", nullable = false, foreignKey = @ForeignKey(name = "FK_consulta_detalle"))
	private Consulta consulta;
	
	@Column(name = "diagnostico", nullable = false, length = 70)
	private String diagnostico;

	@Column(name = "tratamiento", nullable = false, length = 300)
	private String tratamiento;
	
}

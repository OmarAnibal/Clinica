package com.clinica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Paciente Model")
@Entity
@Data
@Table(name = "paciente")
public class Paciente {

	
	/*public Paciente() throws Exception {
		if(this.email.contains("hp")) {
			throw new Exception("El paciente no puede contener groserias en el correo");
		}
	}*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPaciente;
	
	@Schema(description = "nombres del paciente")
	@NotNull
	@Size(min = 3, message = "{nombres.size}")
	@Column(name = "nombres", nullable = false, length = 70)
	private String nombres;
	
	@NotEmpty
	@Size(min = 3, message = "{apellidos.size}")
	@Column(name = "apellidos", nullable = false, length = 70)
	private String apellidos;
	
	@Size(max = 15, message = "Maximo 15 caracteres por N Identificacion")
	@Column(name = "n_identificacion", nullable = false, length = 15)
	private String identificacion;
	
	@Size(max = 30, message = "Maximo 6 caracteres por direccion")
	@Column(name = "direccion", nullable = false, length = 70)
	private String direccion;
	
	@Size(max = 15, message = "Maximo 15 caracteres por telefono")
	@Column(name = "telefono", nullable = true, length = 15)
	private String telefono;

	@Email(message = "Email formato incorrecto")
	//@Pattern(regexp = "")
	@Column(name = "email", nullable = true, length = 70)
	private String email;

}

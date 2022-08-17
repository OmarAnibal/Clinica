package com.clinica.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	private Integer idUsuario;

	@Column(name = "nombres", nullable = false, unique = true)
	private String username;
	
	@Column(name = "clave", nullable = false)
	private String password;
	
	@Column(name = "estado", nullable = false)
	private boolean enabled;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "id_usuario",
	referencedColumnName = "idUsuario"),inverseJoinColumns = 
	@JoinColumn(name = "id_rol", referencedColumnName = "idRol"))
	private List<Rol> roles;
}

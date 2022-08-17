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
@Table(name = "menu")
public class Menu {
	
	
	@Id
	private Integer idMenu;
	
	@Column(name="icono", length = 20)
	private String icono;
	
	@Column(name="nombre", length = 20)
	private String nombre;
	
	@Column(name="url", length = 50)
	private String url;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "menu_rol", joinColumns = @JoinColumn(name = "id_menu", 
	referencedColumnName = "idMenu"), inverseJoinColumns = @JoinColumn(name = "id_rol", 
	referencedColumnName = "idRol"))
	private List<Rol> roles;
}

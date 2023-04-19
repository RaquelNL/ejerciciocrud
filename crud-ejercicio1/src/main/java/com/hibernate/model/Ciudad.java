package com.hibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="persona")
public class Ciudad {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idciudad")
	private int codigo;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="habitantes")
	private int habitantes;
	
	public Ciudad() {
		super();
	}
	
	public Ciudad(String nombre, int habitantes) {
		super();
		this.nombre = nombre;
		this.habitantes = habitantes;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getHabitantes() {
		return habitantes;
	}
	public void setHabitantes(int habitantes) {
		this.habitantes = habitantes;
	}
	

}

package com.magicMovie.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity(name="TIPO_CUENTA")
public class TipoCuenta {
	@Id@GeneratedValue
	@Column(name="ID_TIPO_CUENTA")
	private int Id;
	private String Nombre;
	private int Minutos;
	@OneToMany(mappedBy="TipoCuenta")
	private Set<Cuenta> Cuentas=new HashSet<Cuenta>();
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public int getMinutos() {
		return Minutos;
	}
	public void setMinutos(int minutos) {
		Minutos = minutos;
	}
	public Set<Cuenta> getCuentas() {
		return Cuentas;
	}
	public void setCuentas(Set<Cuenta> cuentas) {
		Cuentas = cuentas;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoCuenta other = (TipoCuenta) obj;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		return true;
	}
}

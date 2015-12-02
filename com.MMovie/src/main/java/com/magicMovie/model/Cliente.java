package com.magicMovie.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.magicMovie.Excepsiones.ExceptionCuentaInactiva;
import com.magicMovie.Excepsiones.ExceptionMinutos;
import com.magicMovie.Util.ComparatorCuentaPorFecha;
@Entity(name="CLIENTE")
@Service
public class Cliente {
	@Id@GeneratedValue
	@Column(name="ID_CLIENTE")
	@JsonIgnore
	private int	Id;
	private String Usuario;
	private String Nombre;
	private String Apellido;
	private String Email;
	private String Contrasenia;
	@OneToMany(mappedBy="Cliente")
	private Set<Cuenta> Cuentas=new HashSet<Cuenta>();
	public String getNombreUsuario() {
		return Usuario;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Set<Cuenta> getCuentas() {
		return Cuentas;
	}
	public void setCuentas(Set<Cuenta> cuentas) {
		Cuentas = cuentas;
	}
	public void setNombreUsuario(String nombreUsuario) {
		Usuario = nombreUsuario;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Usuario == null) ? 0 : Usuario.hashCode());
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
		Cliente other = (Cliente) obj;
		if (Usuario == null) {
			if (other.Usuario != null)
				return false;
		} else if (!Usuario.equals(other.Usuario))
			return false;
		return true;
	}
	public Cuenta getUltimaCuenta() {
		List<Cuenta> cuentas= new ArrayList<Cuenta>();
		cuentas.addAll(this.Cuentas);
		ComparatorCuentaPorFecha comp=new ComparatorCuentaPorFecha();
		cuentas.sort(comp);
		Cuenta ultimaCuenta=cuentas.get(0);
		return ultimaCuenta;
	}
	public boolean addCuenta(Cuenta c) {
		 if (!this.Cuentas.contains(c)) {
			 this.Cuentas.add(c);
			 return true;
		 }
		 return false;
	}
	public void ReservarPelicula(Pelicula p) throws ExceptionCuentaInactiva, ExceptionMinutos {
		Cuenta laUltima=this.getUltimaCuenta();
		Reserva r=new Reserva(laUltima,p);
		laUltima.agregarReserva(r);
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getContrasenia() {
		return Contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		Contrasenia = contrasenia;
	}
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
}

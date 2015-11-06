package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import Excepsiones.ExceptionCuentaInactiva;
import Excepsiones.ExceptionMinutos;
import Util.ComparatorCuentaPorFecha;
import interfaces.IAsignacionMExtras;
@Entity(name="CLIENTE")
public class Cliente {
	@Id@GeneratedValue
	@Column(name="ID_CLIENTE")
	private int	Id;
	private String NombreUsuario;
	private String Nombre;
	private String Apellido;
	private String Email;
	private String Contrasenia;
	@OneToMany(mappedBy="Cliente")
	private Set<Cuenta> Cuentas=new HashSet<Cuenta>();
	public String getNombreUsuario() {
		return NombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		NombreUsuario = nombreUsuario;
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
		result = prime * result + ((NombreUsuario == null) ? 0 : NombreUsuario.hashCode());
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
		if (NombreUsuario == null) {
			if (other.NombreUsuario != null)
				return false;
		} else if (!NombreUsuario.equals(other.NombreUsuario))
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
}

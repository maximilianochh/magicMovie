package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
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
}

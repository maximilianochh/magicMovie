package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
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
}

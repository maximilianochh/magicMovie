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
}

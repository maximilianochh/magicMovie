package model;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
@Entity(name="CUENTA")
public class Cuenta {
	@Id@GeneratedValue
	@Column(name="ID_CUENTA")
	private int Id;
	private Date FechaCreacion;
	@OneToMany(mappedBy="Cuenta")
	private Set<Reserva> Reservas=new HashSet<Reserva>();
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getMinutosExtra() {
		return MinutosExtra;
	}
	public void setMinutosExtra(int minutosExtra) {
		MinutosExtra = minutosExtra;
	}
	public boolean isEstado() {
		return Estado;
	}
	public void setEstado(boolean estado) {
		Estado = estado;
	}
	public Cliente getCliente() {
		return Cliente;
	}
	public void setCliente(Cliente cliente) {
		Cliente = cliente;
	}
	private int MinutosExtra;
	private boolean Estado;
	@ManyToOne
	@JoinColumn(name="ID_TIPO_CUENTA")
	private TipoCuenta TipoCuenta;
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE")
	private Cliente Cliente;
	public Date getFechaCreacion() {
		return FechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		FechaCreacion = fechaCreacion;
	}
	public static void main(String [] args){
		Cuenta c=new Cuenta();
		Session s=new Configuration().configure().buildSessionFactory().openSession();
	}
}

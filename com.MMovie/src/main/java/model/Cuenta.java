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
import javax.persistence.Transient;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Factory.FactoryAsignacion;
import interfaces.IAsignacionMExtras;
@Entity(name="CUENTA")
public class Cuenta {
	@Id@GeneratedValue
	@Column(name="ID_CUENTA")
	private int Id;
	private Date FechaCreacion;
	@OneToMany(mappedBy="Cuenta")
	private Set<Reserva> Reservas=new HashSet<Reserva>();
	private int MinutosExtra;
	private boolean Estado;
	@ManyToOne
	@JoinColumn(name="ID_TIPO_CUENTA")
	private TipoCuenta TipoCuenta;
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE")
	private Cliente Cliente;
	private String EstrategiaMinutosExtra;
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
	public void AgregarReserva(Reserva r) {
		// TODO Auto-generated method stub
		Pelicula peli=r.getPelicula();
		this.Reservas.add(r);
		this.descontarMinutos(peli);
		this.agregarMinutosExtras(peli);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Cliente == null) ? 0 : Cliente.hashCode());
		result = prime * result + ((TipoCuenta == null) ? 0 : TipoCuenta.hashCode());
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
		Cuenta other = (Cuenta) obj;
		if (Cliente == null) {
			if (other.Cliente != null)
				return false;
		} else if (!Cliente.equals(other.Cliente))
			return false;
		if (TipoCuenta == null) {
			if (other.TipoCuenta != null)
				return false;
		} else if (!TipoCuenta.equals(other.TipoCuenta))
			return false;
		return true;
	}
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
	private void descontarMinutos(Pelicula p) {
		this.MinutosExtra-=p.getDuracion();
	}
	private void agregarMinutosExtras(Pelicula p) {
		IAsignacionMExtras asig=FactoryAsignacion.getInstance(this.EstrategiaMinutosExtra);
		this.MinutosExtra+=asig.getMinutosExtras(p);
	}
}

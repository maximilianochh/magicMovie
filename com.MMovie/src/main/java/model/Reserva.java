package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity(name="RESERVA")
public class Reserva {
	@Id@GeneratedValue
	@Column(name="ID_RESERVA")
	private int Id;
	private Date FechaReserva;
	@ManyToOne
	@JoinColumn(name="ID_PELICULA")
	private Pelicula Pelicula;
	@ManyToOne
	@JoinColumn(name="ID_CUENTA")
	private Cuenta Cuenta;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Date getFechaReserva() {
		return FechaReserva;
	}
	public void setFechaReserva(Date fechaReserva) {
		FechaReserva = fechaReserva;
	}
	public Pelicula getPelicula() {
		return Pelicula;
	}
	public void setPelicula(Pelicula pelicula) {
		Pelicula = pelicula;
	}
	public Cuenta getCuenta() {
		return Cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		Cuenta = cuenta;
	}
}

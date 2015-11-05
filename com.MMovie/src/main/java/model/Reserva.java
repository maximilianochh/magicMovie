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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Cuenta == null) ? 0 : Cuenta.hashCode());
		result = prime * result + ((FechaReserva == null) ? 0 : FechaReserva.hashCode());
		result = prime * result + ((Pelicula == null) ? 0 : Pelicula.hashCode());
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
		Reserva other = (Reserva) obj;
		if (Cuenta == null) {
			if (other.Cuenta != null)
				return false;
		} else if (!Cuenta.equals(other.Cuenta))
			return false;
		if (FechaReserva == null) {
			if (other.FechaReserva != null)
				return false;
		} else if (!FechaReserva.equals(other.FechaReserva))
			return false;
		if (Pelicula == null) {
			if (other.Pelicula != null)
				return false;
		} else if (!Pelicula.equals(other.Pelicula))
			return false;
		return true;
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

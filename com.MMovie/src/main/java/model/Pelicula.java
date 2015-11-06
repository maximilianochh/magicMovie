package model;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import Util.ComparatorReservasPorFecha;
@Entity(name="PELICULA")
public class Pelicula {
	public static final int indicadorDePopularidad=1000;
	@Id@GeneratedValue
	@JoinColumn(name="ID_PELICULA")
	private int Id;
	private String Titulo;
	private Date fechaEstreno;
	public Date getFechaEstreno() {
		return fechaEstreno;
	}
	public void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Titulo == null) ? 0 : Titulo.hashCode());
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
		Pelicula other = (Pelicula) obj;
		if (Titulo == null) {
			if (other.Titulo != null)
				return false;
		} else if (!Titulo.equals(other.Titulo))
			return false;
		return true;
	}
	private int Duracion;
	private int Calificacion;
	@OneToMany(mappedBy="Pelicula")
	private Set<Tag> Tags=new HashSet<Tag>();
	public int getDuracion() {
		return Duracion;
	}
	public void setDuracion(int duracion) {
		Duracion = duracion;
	}
	public int getCalificacion() {
		return Calificacion;
	}
	public void setCalificacion(int calificacion) {
		Calificacion = calificacion;
	}
	public Set<Tag> getTags() {
		return Tags;
	}
	public void setTags(Set<Tag> tags) {
		Tags = tags;
	}
	public Set<Reserva> getReservas() {
		return Reservas;
	}
	public void setReservas(Set<Reserva> reservas) {
		Reservas = reservas;
	}
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	@OneToMany(mappedBy="Pelicula")
	private Set<Reserva> Reservas=new HashSet<Reserva>();
	@SuppressWarnings("deprecation")
	public boolean esEstreno() {
		// TODO Auto-generated method stub
		Date today=new Date();
		int difMonth=today.getMonth()-this.fechaEstreno.getMonth();
		if (difMonth!=0) {
			if (difMonth>1) {
				return false;
			}
			int difDay=today.getDay()-this.fechaEstreno.getDay();
			if (difDay>0) {
				return false;
			}
		}
		return true;
	}
	public int getCantReservas() {
		// TODO Auto-generated method stub
		return this.Reservas.size();
	}
	public boolean esPopular() {
		// TODO Auto-generated method stub
		if (this.getCantReservas()<=1000) {
			return false;
		}
		return true;
	}
}

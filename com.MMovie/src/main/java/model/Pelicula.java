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
@Entity(name="PELICULA")
public class Pelicula {
	@Id@GeneratedValue
	@JoinColumn(name="ID_PELICULA")
	private int Id;
	private String Titulo;
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
}

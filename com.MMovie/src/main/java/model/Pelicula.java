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
	private int Duracion;
	private int Calificacion;
	@OneToMany(mappedBy="Pelicula")
	private Set<Tag> Tags=new HashSet<Tag>();
	@OneToMany(mappedBy="Pelicula")
	private Set<Reserva> Reservas=new HashSet<Reserva>();
}

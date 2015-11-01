package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity(name="TAG")
public class Tag {
	@Id@GeneratedValue
	@Column(name="ID_TAG")
	private int Id;
	@ManyToOne
	@JoinColumn(name="ID_PELICULA")
	private Pelicula Pelicula;
	@ManyToOne
	@JoinColumn(name="ID_TIPO_TAG")
	private TipoTag TipoTag;
}

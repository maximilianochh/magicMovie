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
	public Pelicula getPelicula() {
		return Pelicula;
	}
	public void setPelicula(Pelicula pelicula) {
		Pelicula = pelicula;
	}
	public void setTipoTag(TipoTag tipoTag) {
		TipoTag = tipoTag;
	}
	@ManyToOne
	@JoinColumn(name="ID_PELICULA")
	private Pelicula Pelicula;
	@ManyToOne
	@JoinColumn(name="ID_TIPO_TAG")
	private TipoTag TipoTag;
	public TipoTag getTipoTag() {
		return TipoTag;
	}
}

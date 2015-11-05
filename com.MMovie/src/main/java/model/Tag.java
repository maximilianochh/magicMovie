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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Pelicula == null) ? 0 : Pelicula.hashCode());
		result = prime * result + ((TipoTag == null) ? 0 : TipoTag.hashCode());
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
		Tag other = (Tag) obj;
		if (Pelicula == null) {
			if (other.Pelicula != null)
				return false;
		} else if (!Pelicula.equals(other.Pelicula))
			return false;
		if (TipoTag == null) {
			if (other.TipoTag != null)
				return false;
		} else if (!TipoTag.equals(other.TipoTag))
			return false;
		return true;
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

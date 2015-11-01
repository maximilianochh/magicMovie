package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
@Entity(name="TIPO_TAG")
public class TipoTag {
	@Id@GeneratedValue
	@Column(name="ID_TIPO_TAG")
	private int Id;
	private String Nombre;
	@OneToMany(mappedBy="TipoTag")
	private Set<Tag> Tags=new HashSet<Tag>();
}

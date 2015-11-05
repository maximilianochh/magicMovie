package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import interfaces.IAsignacionMExtras;
@Entity(name="ASIGNACION")
public class AsignacionMainStream implements IAsignacionMExtras  {
	private int incMinutos=10;
	private int mainStreamReservas=1000;
	
	public int getPuntosExtras(Pelicula p) {
		// TODO Auto-generated method stub
		if (mainStreamReservas>p.getCantReservas()) {
			return 0;
		}
		return incMinutos;
	}
}

package com.magicMovie.model;

import com.magicMovie.interfaces.IAsignacionMExtras;

public class AsignacionClientesActualizados implements IAsignacionMExtras {
	private int incMinutos=10;
	public int getMinutosExtras(Pelicula p) {
		if (!p.esEstreno()) {
			return 0;
		}
		if (p.esPopular()) {
			return 0;
		}
		return incMinutos;
	}
}

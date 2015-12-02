package com.magicMovie.Util;

import java.util.Comparator;

import com.magicMovie.model.Cuenta;

public class ComparatorCuentaPorFecha implements Comparator<Cuenta> {
	public int compare(Cuenta o1, Cuenta o2) {
		// TODO Auto-generated method stub
		if (o1.getFechaCreacion().before(o2.getFechaCreacion())) {
			return -1;
		} else {
			if (o2.getFechaCreacion().before(o1.getFechaCreacion())) {
				return 1;
			}
			return 0;
		}
	}

}

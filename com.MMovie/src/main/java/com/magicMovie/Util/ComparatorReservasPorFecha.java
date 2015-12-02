package com.magicMovie.Util;

import java.util.Comparator;

import com.magicMovie.model.Reserva;

public class ComparatorReservasPorFecha implements Comparator<Reserva> {

	public int compare(Reserva o1, Reserva o2) {
		// TODO Auto-generated method stub
		if (o1.getFechaReserva().before(o2.getFechaReserva())) {
			return -1;
		};
		if (o2.getFechaReserva().before(o1.getFechaReserva())) {
			return 1;
		};
		return 0;
	}
	
}

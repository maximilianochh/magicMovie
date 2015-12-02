package com.magicMovie.Util;

import java.util.Comparator;

import com.magicMovie.model.Pelicula;

public class ComparatorPeliculaPorReservas implements Comparator<Pelicula> {
	public int compare(Pelicula o1, Pelicula o2) {
		// TODO Auto-generated method stub
		int reservas1=o1.getReservas().size();
		int reservas2=o2.getReservas().size();
		if (reservas1>reservas2) {
			return -1;
		} else {
			if (reservas1<reservas2)
				return 1;
			
			}
			return 0; 
		}
	}
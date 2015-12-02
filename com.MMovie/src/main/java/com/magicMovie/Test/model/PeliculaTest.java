package com.magicMovie.Test.model;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.magicMovie.model.Cuenta;
import com.magicMovie.model.Pelicula;
import com.magicMovie.model.Reserva;

public class PeliculaTest {
	Pelicula pelicula0=new Pelicula();
	Pelicula pelicula1=new Pelicula();
	Pelicula pelicula2=new Pelicula();
	Pelicula pelicula3=new Pelicula();
	@SuppressWarnings("deprecation")
	@Before
	public void setPelicula() {
		pelicula0=new Pelicula();
		pelicula0.setFechaEstreno(new Date());
		pelicula1=new Pelicula();
		pelicula1.setFechaEstreno(new Date());
		@SuppressWarnings("deprecation")
		int dosMesesAntes=pelicula1.getFechaEstreno().getMonth()-1;
		pelicula1.getFechaEstreno().setMonth(dosMesesAntes);
	}
	@Test
	public void esEstreno() {
		assertEquals(pelicula0.esEstreno(),true);
		assertEquals(pelicula1.esEstreno(),false);
	}
	@Before
	public void setPelicula1() {
		Set<Reserva> reservas=new HashSet<Reserva>();
		Cuenta c=new Cuenta();
		for (int i=0;i<1000;i++) {
			Reserva r=new Reserva(c,pelicula0);
			pelicula0.addReserva(r);
		}
		for (int i=0;i<999;i++) {
			Reserva r=new Reserva(c,pelicula0);
			pelicula1.addReserva(r);
		}
		for (int i=0;i<999;i++) {
			Reserva r=new Reserva(c,pelicula0);
			pelicula3.addReserva(r);
		}
	}
	@Test
	public void esPopular() {
		assertEquals(pelicula0.esEstreno(),true);
		assertEquals(pelicula1.esEstreno(),false);
	}
}

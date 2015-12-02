package com.magicMovie.Test.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.magicMovie.model.AsignacionClientesActualizados;
import com.magicMovie.model.Cuenta;
import com.magicMovie.model.Pelicula;
import com.magicMovie.model.Reserva;

public class AsignacionClientesActualizadosTest {
	private AsignacionClientesActualizados asig=new AsignacionClientesActualizados(); 
	private Cuenta cuenta=new Cuenta();
	private Pelicula peli1=new Pelicula();
	private Pelicula peli2=new Pelicula();
	@Before
	public void before() {
		for (int i=0;i<120000;i++) {
			Reserva r=new Reserva(cuenta,peli1);
			peli1.addReserva(r);
		}
	}
	@Test
	public void getMExtras() {
		System.out.println(peli1.getCantReservas());
		assertEquals(asig.getMinutosExtras(peli1)!=0,false);
		assertEquals(asig.getMinutosExtras(peli2)!=0,true);
	}
}

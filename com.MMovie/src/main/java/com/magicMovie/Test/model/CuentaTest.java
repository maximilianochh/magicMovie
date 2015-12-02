package com.magicMovie.Test.model;
import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.magicMovie.Excepsiones.ExceptionCuentaInactiva;
import com.magicMovie.Excepsiones.ExceptionMinutos;
import com.magicMovie.model.Cuenta;
import com.magicMovie.model.Pelicula;
import com.magicMovie.model.Reserva;
import com.magicMovie.model.TipoCuenta;
public class CuentaTest {
	Cuenta cuenta;
	Pelicula pelicula;
	Pelicula pelicula1;
	TipoCuenta tCuenta;
	Reserva reserva;
	@Before
	public void setTest1(){
		cuenta=new Cuenta();
		pelicula=new Pelicula();
		pelicula1=new Pelicula();
		tCuenta=new TipoCuenta();
		tCuenta.setMinutos(100);
		tCuenta.setNombre("comun");
		cuenta.setTipoCuenta(tCuenta);
		pelicula.setFechaEstreno(new Date());
		pelicula.setDuracion(10);
		pelicula1.setDuracion(1000);
		reserva=new Reserva(cuenta,pelicula1);
	}
	@Before
	public void setTest2(){
		cuenta=new Cuenta();
		pelicula=new Pelicula();
		tCuenta=new TipoCuenta();
		tCuenta.setMinutos(1000);
		tCuenta.setNombre("comun");
		cuenta.setTipoCuenta(tCuenta);
		pelicula.setFechaEstreno(new Date());
		pelicula.setDuracion(100999);
		reserva=new Reserva(cuenta,pelicula);
	}
	@Test
	public void getMinutosExtras() {
		assertEquals(cuenta.getMinutosExtra()==0,true);
	}
	@Test
	public void getMInutosDisponibles() {
		System.out.println(pelicula.getDuracion());
		assertEquals((cuenta.getMinutosTotales()>pelicula.getDuracion()),true);
	}
	@Test
	public void puedeReservar()  {
		cuenta.setEstado(true);
		assertEquals((cuenta.puedeReservar(pelicula)),true);
	}
	@Test
	public void isEstado() {
		cuenta.setEstado(true);
		assertEquals(cuenta.isEstado(),true);
	}
	@After
	public void clear() {
		cuenta=new Cuenta();
		pelicula=new Pelicula();
		tCuenta=new TipoCuenta();
		tCuenta.setMinutos(1000);
		tCuenta.setNombre("comun");
		cuenta.setTipoCuenta(tCuenta);
		pelicula.setFechaEstreno(new Date());
		pelicula.setDuracion(100999);
		reserva=new Reserva(cuenta,pelicula);
	}
	@Test(expected=ExceptionMinutos.class)
	public void agregarReserva() throws ExceptionMinutos, ExceptionCuentaInactiva {
		cuenta.setEstado(true);
		cuenta.agregarReserva(reserva);
	}
	@Test
	public void agregarReserva1() throws ExceptionMinutos, ExceptionCuentaInactiva {
		Reserva reserva1=new Reserva(cuenta,pelicula);
		cuenta.setEstado(true);
		cuenta.agregarReserva(reserva1);
		assertEquals(cuenta.getReservas().isEmpty(),false);
	}
}

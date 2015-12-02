package com.magicMovie.Test.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.magicMovie.Excepsiones.ExceptionCuentaInactiva;
import com.magicMovie.Excepsiones.ExceptionMinutos;
import com.magicMovie.model.Cliente;
import com.magicMovie.model.Cuenta;
import com.magicMovie.model.Pelicula;
public class ClienteTest {
	private Cliente cliente;
	@Before
	public void setCliente() {
		cliente=new Cliente();
		cliente.setNombreUsuario("leo");
		Cuenta c=new Cuenta();
		Date ayer=new Date();
		ayer.setMonth(1);
		cliente.addCuenta(c);
	}
	@Test
	public void equals() {
		Cliente cliente1=new Cliente();
		cliente1.setNombreUsuario("leo");
		assertEquals(cliente.equals(cliente1),true);
	}
	@Test
	public void getUltima() {
		Cuenta c=new Cuenta();
		cliente.addCuenta(c);
		assertEquals(cliente.getUltimaCuenta().equals(c),true);
	}
	@Test
	public void addCuenta() {
		Cuenta c=new Cuenta();
		assertEquals(cliente.addCuenta(c),false);
	}	
}

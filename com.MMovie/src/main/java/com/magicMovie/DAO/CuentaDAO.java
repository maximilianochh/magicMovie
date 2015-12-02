package com.magicMovie.DAO;

import java.util.List;

import com.magicMovie.model.Cliente;
import com.magicMovie.model.Cuenta;

public interface CuentaDAO{
	public boolean save(Cuenta c);
	public boolean delete(Cuenta c);
	public List<Cuenta> getAll(Cliente c);
	public Cuenta getCuentaActual(Cliente c);
}
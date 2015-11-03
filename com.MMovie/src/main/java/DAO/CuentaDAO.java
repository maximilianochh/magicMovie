package DAO;

import java.util.List;

import model.Cliente;
import model.Cuenta;

public interface CuentaDAO{
	public boolean save(Cuenta c);
	public boolean delete(Cuenta c);
	public List<Cuenta> getAll(Cliente c);
	public Cuenta getCuentaActual(Cliente c);
}
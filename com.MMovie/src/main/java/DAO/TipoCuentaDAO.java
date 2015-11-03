package DAO;

import java.util.List;

import model.TipoCuenta;

public interface TipoCuentaDAO{
	public boolean save(TipoCuenta tc);
	public boolean delete(TipoCuenta tc);
	public List<TipoCuenta> getAll();
}
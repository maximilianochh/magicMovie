package com.magicMovie.DAO;

import java.util.List;

import com.magicMovie.model.TipoCuenta;

public interface TipoCuentaDAO{
	public boolean save(TipoCuenta tc);
	public boolean delete(TipoCuenta tc);
	public List<TipoCuenta> getAll();
}
package com.magicMovie.DAO;

import java.util.List;

import com.magicMovie.model.TipoTag;

public interface TipoTagDAO{
	public boolean save(TipoTag tt);
	public boolean delete(TipoTag tt);
	public List<TipoTag> getAll();
}
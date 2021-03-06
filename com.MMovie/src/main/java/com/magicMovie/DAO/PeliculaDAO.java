package com.magicMovie.DAO;

import java.util.List;

import com.magicMovie.model.Pelicula;

public interface PeliculaDAO{
	public boolean save(Pelicula p);
	public boolean delete(Pelicula p);
	public List<Pelicula> getAll(String tag);
	public int getRecordMasReservas();
	public int getRecordMenosReservas();
	public List<Pelicula> getPelicula(String nombre);
}
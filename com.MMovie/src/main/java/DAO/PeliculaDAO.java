package DAO;

import java.util.List;

import model.Pelicula;

public interface PeliculaDAO{
	public boolean save(Pelicula p);
	public boolean delete(Pelicula p);
	public List<Pelicula> getAll(Pelicula p,String tag);
	public int getRecordMasReservas();
	public int getRecordMenosReservas();
	public List<Pelicula> getPelicula(String nombre);
}
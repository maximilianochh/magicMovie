package com.magicMovie.DAO;

import java.util.List;

import com.magicMovie.model.Cliente;
import com.magicMovie.model.Pelicula;
import com.magicMovie.model.Reserva;

public interface ReservaDAO{
	public boolean add(Reserva r);
	public boolean delete(Reserva r);
	public List<Reserva> getAll(Cliente c);
	public int getCantReservas(Pelicula p);	
}
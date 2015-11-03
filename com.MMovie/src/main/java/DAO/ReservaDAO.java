package DAO;

import java.util.List;

import model.Cliente;
import model.Pelicula;
import model.Reserva;

public interface ReservaDAO{
	public boolean add(Reserva r);
	public boolean delete(Reserva r);
	public List<Reserva> getAll(Cliente c);
	public int getCantReservas(Pelicula p);	
}
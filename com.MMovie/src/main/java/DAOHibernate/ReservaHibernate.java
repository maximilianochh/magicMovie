package DAOHibernate;

import java.util.Iterator;
import java.util.List;

import DAO.ReservaDAO;
import Util.HibernateSession;
import model.Cliente;
import model.Pelicula;
import model.Reserva;

public class ReservaHibernate implements ReservaDAO {

	public boolean add(Reserva r) {
		// TODO Auto-generated method stub
		HibernateSession hs=HibernateSession.getInstance();
		return hs.save(r);
	}

	public boolean delete(Reserva r) {
		// TODO Auto-generated method stub
		HibernateSession hs=HibernateSession.getInstance();
		return hs.delete(r);
	}
	public List<Reserva> getAll(Cliente c) {
		// TODO Auto-generated method stub
		HibernateSession hs=HibernateSession.getInstance();
		String className=c.getClass().getSimpleName().toUpperCase();
		List<Reserva> reservas=(List<Reserva>)(List<?>) hs.getAll("RESERVA");
		Iterator<Reserva> it=reservas.iterator();
		while (it.hasNext()) {
			Reserva r=it.next();
			if (!r.getCuenta().getCliente().equals(c)) {
				it.remove();
			}
		}
		return reservas;
	}

	public int getCantReservas(Pelicula p) {
		// TODO Auto-generated method stub
		HibernateSession hs=HibernateSession.getInstance();
		List<Reserva> reservas=(List<Reserva>)(List<?>) hs.getAll("RESERVA");
		Iterator<Reserva> it=reservas.iterator();
		while (it.hasNext()) {
			Reserva r=it.next();
			if (!r.getPelicula().equals(p)) {
				it.remove();
			}
		}
		return reservas.size();
	}
		
}
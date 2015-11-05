package DAOHibernate;

import java.util.Iterator;
import java.util.List;

import DAO.PeliculaDAO;
import Util.ComparatorPeliculaPorReservas;
import Util.HibernateSession;
import model.Pelicula;
import model.Tag;

public class PeliculaHibernate implements PeliculaDAO{

	public boolean save(Pelicula p) {
		// TODO Auto-generated method stub
		HibernateSession hs=HibernateSession.getInstance();
		return hs.save(p);
	}
	public boolean delete(Pelicula p) {
		// TODO Auto-generated method stub
		HibernateSession hs=HibernateSession.getInstance();
		return hs.delete(p);
	}

	public List<Pelicula> getAll(String tag) {
		// TODO Auto-generated method stub
		HibernateSession hs=HibernateSession.getInstance();
		List<Pelicula> pelis=(List<Pelicula>)(List<?>)hs.getAll("Pelicula");
		Iterator<Pelicula> it=pelis.iterator();
		while (it.hasNext()) {
			List<Tag> tags=(List<Tag>) it.next().getTags();
			Iterator<Tag> itt=tags.iterator();
			while (itt.hasNext()) {
				Tag thisTag=itt.next();
				if (thisTag.getTipoTag().getNombre().equalsIgnoreCase(tag)){
					break;
				}
				it.remove();
			}
		}
		return pelis; 
	}

	public int getRecordMasReservas() {
		// TODO Auto-generated method stub
		HibernateSession hs=HibernateSession.getInstance();
		List<Pelicula> pelis=(List<Pelicula>)(List<?>)hs.getAll("Pelicula");
		ComparatorPeliculaPorReservas c=new ComparatorPeliculaPorReservas();
		pelis.sort(c);
		int recordPelis=pelis.get(0).getReservas().size();
		return recordPelis;
	}
	public int getRecordMenosReservas() {
		// TODO Auto-generated method stub
		HibernateSession hs=HibernateSession.getInstance();
		List<Pelicula> pelis=(List<Pelicula>)(List<?>)hs.getAll("PELICULA");
		ComparatorPeliculaPorReservas c=new ComparatorPeliculaPorReservas();
		pelis.sort(c);
		int last=pelis.size()-1;
		int recordMin=pelis.get(last).getReservas().size();
		return recordMin;
	}
	public List<Pelicula> getPelicula(String nombre) {
		// TODO Auto-generated method stub
		HibernateSession hs=HibernateSession.getInstance();
		List<Pelicula> pelis=(List<Pelicula>)(List<?>)hs.getAll("PELICULA");
		Iterator<Pelicula> it=pelis.iterator();
		String titleSearch=nombre.toUpperCase();
		while (it.hasNext()) {
			Pelicula p=it.next();
			String newTitle=p.getTitulo().toUpperCase();
			if (!newTitle.contains(titleSearch)) {
				it.remove();
			}
		}
		return pelis;
	}
	
}
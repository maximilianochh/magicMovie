package DAOHibernate;

import java.util.Iterator;
import java.util.List;
import DAO.TagDAO;
import Util.HibernateSession;
import model.Pelicula;
import model.Reserva;
import model.Tag;

public class TagHibernate implements TagDAO{

	public boolean save(Tag t) {
		// TODO Auto-generated method stub
		HibernateSession hs=HibernateSession.getInstance();
		return hs.save(t);
	}

	public boolean delete(Tag t) {
		// TODO Auto-generated method stub
		HibernateSession hs=HibernateSession.getInstance();
		return hs.delete(t);
	}

	public List<Tag> getAll(String tipoTag) {
		// TODO Auto-generated method stub
		HibernateSession hs=HibernateSession.getInstance();
		List<Tag> tags=(List<Tag>)(List<?>) hs.getAll("TAG");
		Iterator<Tag> it=tags.iterator();
		while (it.hasNext()) {
			Tag t=it.next();
			if (!t.getTipoTag().getNombre().equals(tipoTag)) {
				it.remove();
			}
		}
		return tags;
	}

	public List<Tag> getAll(Pelicula p) {
		// TODO Auto-generated method stub
		HibernateSession hs=HibernateSession.getInstance();
		List<Tag> tags=(List<Tag>)(List<?>) hs.getAll("TAG");
		Iterator<Tag> it=tags.iterator();
		while (it.hasNext()) {
			Tag t=it.next();
			if (!t.getPelicula().equals(p)) {
				it.remove();
			}
		}
		return tags;
	}
}
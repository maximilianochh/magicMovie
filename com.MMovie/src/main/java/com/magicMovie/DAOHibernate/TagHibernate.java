package com.magicMovie.DAOHibernate;

import java.util.Iterator;
import java.util.List;

import com.magicMovie.DAO.TagDAO;
import com.magicMovie.Util.HibernateSession;
import com.magicMovie.model.Pelicula;
import com.magicMovie.model.Reserva;
import com.magicMovie.model.Tag;

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
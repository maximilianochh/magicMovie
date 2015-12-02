package com.magicMovie.DAOHibernate;

import java.util.List;

import com.magicMovie.DAO.TipoTagDAO;
import com.magicMovie.Util.HibernateSession;
import com.magicMovie.model.TipoCuenta;
import com.magicMovie.model.TipoTag;

public class TipoTagHibernate implements TipoTagDAO{

	public boolean save(TipoTag tt) {
		// TODO Auto-generated method stub
		HibernateSession hs=HibernateSession.getInstance();
		return hs.save(tt);
	}
	public boolean delete(TipoTag tt) {
		// TODO Auto-generated method stub
		HibernateSession hs=HibernateSession.getInstance();
		return hs.delete(tt);
	}
	public List<TipoTag> getAll() {
		// TODO Auto-generated method stub
		HibernateSession hs=HibernateSession.getInstance();
		List<TipoTag> ttag=(List<TipoTag>)(List<?>) hs.getAll("TIPO_CUENTA");
		return ttag;
	}
}
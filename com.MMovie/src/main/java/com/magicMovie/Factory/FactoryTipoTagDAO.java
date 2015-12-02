package com.magicMovie.Factory;

import com.magicMovie.DAO.TipoTagDAO;
import com.magicMovie.DAOHibernate.TipoTagHibernate;

public class FactoryTipoTagDAO{
	public TipoTagDAO getInstance(String orm) {
		TipoTagDAO c=new TipoTagHibernate();
		if (orm.equalsIgnoreCase("Hibernate")) {
				return c;
		}
		return c;		
	}
}
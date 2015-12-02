package com.magicMovie.Factory;

import com.magicMovie.DAO.ClienteDAO;
import com.magicMovie.DAOHibernate.ClienteHibernate;

public class FactoryClienteDAO  {
	public ClienteDAO getInstance(String orm) {
		ClienteDAO c=new ClienteHibernate();
		if (orm.equalsIgnoreCase("Hibernate")) {
			return c;
		}
		return c;		
	}
}

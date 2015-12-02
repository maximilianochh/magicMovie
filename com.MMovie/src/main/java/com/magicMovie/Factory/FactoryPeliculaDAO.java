package com.magicMovie.Factory;
import java.util.Iterator;
import java.util.List;

import com.magicMovie.DAO.ClienteDAO;
import com.magicMovie.DAO.CuentaDAO;
import com.magicMovie.DAO.PeliculaDAO;
import com.magicMovie.DAOHibernate.ClienteHibernate;
import com.magicMovie.DAOHibernate.CuentaHibernate;
import com.magicMovie.DAOHibernate.PeliculaHibernate;
import com.magicMovie.Util.ComparatorCuentaPorFecha;
import com.magicMovie.Util.ConversorListas;
import com.magicMovie.Util.HibernateSession;
import com.magicMovie.model.Cliente;
import com.magicMovie.model.Cuenta;
public class FactoryPeliculaDAO {
	public PeliculaDAO getInstance(String orm) {
		PeliculaDAO c=new PeliculaHibernate();
		if (orm.equalsIgnoreCase("Hibernate")) {
			return c;
		}
		return c;		
	}
}
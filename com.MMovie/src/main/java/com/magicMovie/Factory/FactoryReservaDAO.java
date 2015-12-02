package com.magicMovie.Factory;
import java.util.Iterator;
import java.util.List;

import com.magicMovie.DAO.ClienteDAO;
import com.magicMovie.DAO.CuentaDAO;
import com.magicMovie.DAO.ReservaDAO;
import com.magicMovie.DAOHibernate.ClienteHibernate;
import com.magicMovie.DAOHibernate.CuentaHibernate;
import com.magicMovie.DAOHibernate.ReservaHibernate;
import com.magicMovie.Util.ComparatorCuentaPorFecha;
import com.magicMovie.Util.ConversorListas;
import com.magicMovie.Util.HibernateSession;
import com.magicMovie.model.Cliente;
import com.magicMovie.model.Cuenta;
public class FactoryReservaDAO {
	public ReservaDAO getInstance(String orm) {
		ReservaDAO r=new ReservaHibernate();
		if (orm.equalsIgnoreCase("Hibernate")) {
			return r;
		}
		return r;		
	}
}
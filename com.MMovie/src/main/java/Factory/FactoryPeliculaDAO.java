package Factory;
import java.util.Iterator;
import java.util.List;

import DAO.ClienteDAO;
import DAO.CuentaDAO;
import DAO.PeliculaDAO;
import DAOHibernate.ClienteHibernate;
import DAOHibernate.CuentaHibernate;
import DAOHibernate.PeliculaHibernate;
import Util.ComparatorCuentaPorFecha;
import Util.ConversorListas;
import Util.HibernateSession;
import model.Cliente;
import model.Cuenta;
public class FactoryPeliculaDAO {
	public PeliculaDAO getInstance(String orm) {
		PeliculaDAO c=new PeliculaHibernate();
		if (orm.equalsIgnoreCase("Hibernate")) {
			return c;
		}
		return c;		
	}
}
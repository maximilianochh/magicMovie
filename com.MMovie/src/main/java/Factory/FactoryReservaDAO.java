package Factory;
import java.util.Iterator;
import java.util.List;

import DAO.ClienteDAO;
import DAO.CuentaDAO;
import DAO.ReservaDAO;
import DAOHibernate.ClienteHibernate;
import DAOHibernate.CuentaHibernate;
import DAOHibernate.ReservaHibernate;
import Util.ComparatorCuentaPorFecha;
import Util.ConversorListas;
import Util.HibernateSession;
import model.Cliente;
import model.Cuenta;
public class FactoryReservaDAO {
	public ReservaDAO getInstance(String orm) {
		ReservaDAO r=new ReservaHibernate();
		if (orm.equalsIgnoreCase("Hibernate")) {
			return r;
		}
		return r;		
	}
}
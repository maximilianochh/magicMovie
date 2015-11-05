package Factory;
import java.util.Iterator;
import java.util.List;

import DAO.ClienteDAO;
import DAO.CuentaDAO;
import DAOHibernate.ClienteHibernate;
import DAOHibernate.CuentaHibernate;
import Util.ComparatorCuentaPorFecha;
import Util.ConversorListas;
import Util.HibernateSession;
import model.Cliente;
import model.Cuenta;
public class FactoryCuentaDAO {
	public CuentaDAO getInstance(String orm) {
		CuentaDAO c=new CuentaHibernate();
		if (orm.equalsIgnoreCase("Hibernate")) {
			return c;
		}
		return c;		
	}
}
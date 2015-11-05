package Factory;
import java.util.Iterator;
import java.util.List;

import DAO.ClienteDAO;
import DAO.CuentaDAO;
import DAO.TipoCuentaDAO;
import DAOHibernate.ClienteHibernate;
import DAOHibernate.CuentaHibernate;
import DAOHibernate.TipoCuentaHibernate;
import Util.ComparatorCuentaPorFecha;
import Util.ConversorListas;
import Util.HibernateSession;
import model.Cliente;
import model.Cuenta;
public class FactoryTipoCuentaDAO {
	public TipoCuentaDAO getInstance(String orm) {
		TipoCuentaDAO c=new TipoCuentaHibernate();
		if (orm.equalsIgnoreCase("Hibernate")) {
			return c;
		}
		return c;		
	}
}
package Factory;
import java.util.Iterator;
import java.util.List;

import DAO.ClienteDAO;
import DAO.CuentaDAO;
import DAO.TagDAO;
import DAOHibernate.ClienteHibernate;
import DAOHibernate.CuentaHibernate;
import DAOHibernate.TagHibernate;
import Util.ComparatorCuentaPorFecha;
import Util.ConversorListas;
import Util.HibernateSession;
import model.Cliente;
import model.Cuenta;
public class FactoryTagDAO {
	public TagDAO getInstance(String orm) {
		TagDAO c=new TagHibernate();
		if (orm.equalsIgnoreCase("Hibernate")) {
			return c;
		}
		return c;		
	}
}
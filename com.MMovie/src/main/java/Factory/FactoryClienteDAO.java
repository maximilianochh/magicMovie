package Factory;

import DAO.ClienteDAO;
import DAOHibernate.ClienteHibernate;

public class FactoryClienteDAO  {
	public ClienteDAO getInstance(String orm) {
		ClienteDAO c=new ClienteHibernate();
		if (orm.equalsIgnoreCase("Hibernate")) {
			return c;
		}
		return c;		
	}
}

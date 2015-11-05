package Factory;

import DAO.TipoTagDAO;
import DAOHibernate.TipoTagHibernate;

public class FactoryTipoTagDAO{
	public TipoTagDAO getInstance(String orm) {
		TipoTagDAO c=new TipoTagHibernate();
		if (orm.equalsIgnoreCase("Hibernate")) {
				return c;
		}
		return c;		
	}
}
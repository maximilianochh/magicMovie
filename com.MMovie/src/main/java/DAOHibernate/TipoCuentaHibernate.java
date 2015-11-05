package DAOHibernate;

import java.util.List;

import DAO.TipoCuentaDAO;
import Util.HibernateSession;
import model.Tag;
import model.TipoCuenta;

public class TipoCuentaHibernate implements TipoCuentaDAO {
	public boolean save(TipoCuenta tc) {
		// TODO Auto-generated method stub
		HibernateSession hs=HibernateSession.getInstance();
		return hs.save(tc);
	}
	public boolean delete(TipoCuenta tc) {
		// TODO Auto-generated method stub
		HibernateSession hs=HibernateSession.getInstance();
		return hs.delete(tc);
	}
	public List<TipoCuenta> getAll() {
		// TODO Auto-generated method stub
		HibernateSession hs=HibernateSession.getInstance();
		List<TipoCuenta> tCuenta=(List<TipoCuenta>)(List<?>) hs.getAll("TIPO_CUENTA");
		return tCuenta;
	}
}
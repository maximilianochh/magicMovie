package DAOHibernate;
import java.util.Iterator;
import java.util.List;

import DAO.CuentaDAO;
import Util.ComparatorCuentaPorFecha;
import Util.ConversorListas;
import Util.HibernateSession;
import model.Cliente;
import model.Cuenta;
public class CuentaHibernate implements CuentaDAO{
	public boolean save(Cuenta c) {
		// TODO Auto-generated method stub
		HibernateSession hs=HibernateSession.getInstance();
		return hs.save(c);
	}
	public boolean delete(Cuenta c) {
		// TODO Auto-generated method stub
		HibernateSession hs=HibernateSession.getInstance();
		return hs.delete(c);
	}

	public List<Cuenta> getAll(Cliente c) {
		HibernateSession hs= HibernateSession.getInstance();
		List<Object> lo=hs.getAll("CUENTA");
		List<Cuenta> lc=(List<Cuenta>)(List<?>)lo;
		Iterator<Cuenta> it=lc.iterator();
		while (it.hasNext()) {
			Cuenta cu=it.next();
			if (!cu.getCliente().equals(c)) {
				it.remove();
			}
		}
		return lc;
	}
	public Cuenta getCuentaActual(Cliente c) {
		// TODO Auto-generated method stub
		List<Cuenta> lc=this.getAll(c);
		ComparatorCuentaPorFecha comp=new ComparatorCuentaPorFecha();
		lc.sort(comp);
		return lc.get(0);
	}
}
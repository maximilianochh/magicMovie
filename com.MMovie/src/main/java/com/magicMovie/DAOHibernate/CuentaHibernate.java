package com.magicMovie.DAOHibernate;
import java.util.Iterator;
import java.util.List;

import com.magicMovie.DAO.CuentaDAO;
import com.magicMovie.Util.ComparatorCuentaPorFecha;
import com.magicMovie.Util.ConversorListas;
import com.magicMovie.Util.HibernateSession;
import com.magicMovie.model.Cliente;
import com.magicMovie.model.Cuenta;
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
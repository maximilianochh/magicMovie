package DAOHibernate;

import java.util.List;

import DAO.ClienteDAO;
import Util.ConversorListas;
import Util.HibernateSession;
import model.Cliente;

public class ClienteHibernate implements ClienteDAO{
	public boolean save(Cliente c) {
		// TODO Auto-generated method stub
		HibernateSession hs= HibernateSession.getInstance();
		return hs.save(c);
	}
	public List<Cliente> getAll() {
		// TODO Auto-generated method stub
		HibernateSession hs= HibernateSession.getInstance();
		List<Object> lo=hs.getAll("Cliente");
		List<Cliente> lc=ConversorListas.convertir(lo);
		return lc;
	}
	public boolean delete(Cliente c) {
		// TODO Auto-generated method stub
		HibernateSession hs= HibernateSession.getInstance();
		return hs.delete(c);
	}

	public Cliente get(String nomUser) {
		// TODO Auto-generated method stub
		HibernateSession hs= HibernateSession.getInstance();
		List<Cliente> lc=this.getAll();
		for (Cliente c:lc) {
			if (c.getNombreUsuario().equals(nomUser)) {
				return c;
			}
		};
		return null;
	}
}
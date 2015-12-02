package com.magicMovie.DAOHibernate;

import java.util.List;

import com.magicMovie.DAO.ClienteDAO;
import com.magicMovie.Util.ConversorListas;
import com.magicMovie.Util.HibernateSession;
import com.magicMovie.model.Cliente;

public class ClienteHibernate implements ClienteDAO{
	public boolean save(Cliente c) {
		// TODO Auto-generated method stub
		HibernateSession hs= HibernateSession.getInstance();
		return hs.save(c);
	}
	public List<Cliente> getAll() {
		// TODO Auto-generated method stub
		HibernateSession hs= HibernateSession.getInstance();
		List<Object> lo=hs.getAll("CLIENTE");
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
	public Cliente checkCliente(Cliente c) {
		Cliente clienteBuscado=this.get(c.getUsuario());
		if (clienteBuscado==null) {
			return null;
		}
		if (!clienteBuscado.getContrasenia().equals(c.getContrasenia())) {
			return null;
		}
		return clienteBuscado;		
	}
}
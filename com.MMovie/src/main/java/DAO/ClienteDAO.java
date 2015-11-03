package DAO;

import java.util.List;

import model.Cliente;

public interface ClienteDAO{
	public boolean save(Cliente c);
	public List<Cliente> getAll();
	public boolean delete(Cliente c);
	public Cliente get(String nomUser);
}
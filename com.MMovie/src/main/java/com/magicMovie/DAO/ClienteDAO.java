package com.magicMovie.DAO;

import java.util.List;

import com.magicMovie.model.Cliente;

public interface ClienteDAO{
	public boolean save(Cliente c);
	public List<Cliente> getAll();
	public boolean delete(Cliente c);
	public Cliente get(String nomUser);
}
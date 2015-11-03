package DAO;

import java.util.List;

import javax.servlet.jsp.tagext.Tag;

import model.Pelicula;

public interface TagDAO{
	public boolean save(Tag t);
	public boolean delete(Tag t);
	public List<Tag> getAll(String tipoTag);
	public List<Tag> getAll(Pelicula p);
}
package com.magicMovie.DAO;

import java.util.List;

import com.magicMovie.model.Pelicula;
import com.magicMovie.model.Tag;

public interface TagDAO{
	public boolean save(Tag t);
	public boolean delete(Tag t);
	public List<Tag> getAll(String tipoTag);
	public List<Tag> getAll(Pelicula p);
}
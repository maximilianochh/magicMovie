package com.magicMovie.Util;

import java.util.ArrayList;
import java.util.List;

import com.magicMovie.model.Cliente;

public class ConversorListas {
	public static List<Cliente> convertir(List<Object> lo) {
		List<Cliente> lc=new ArrayList<Cliente>();
		for (Object o:lo) {
			Cliente c=(Cliente) o;
			lc.add(c);
		}
		return lc;
	}
	
	
}

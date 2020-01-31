package com.ocaso.seguros.persistencia.dao;

import java.util.List;

import com.ocaso.seguros.modelo.Seguro;


public interface SeguroDAO extends GenericDAO<Seguro, Integer> {

	public List<Object[]> findNifNombre();
	public Seguro findByName(String nombre, String apellido1, String apellido2);
	public long findNumeroSeguros();
	public List<Object[]> findNIFyAsistencias();
	
}

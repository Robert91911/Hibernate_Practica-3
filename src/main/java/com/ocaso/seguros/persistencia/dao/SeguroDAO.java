package com.ocaso.seguros.persistencia.dao;

import java.util.List;

import com.ocaso.seguros.modelo.Seguro;


public interface SeguroDAO extends GenericDAO<Seguro, Integer> {

	public List<Seguro> findByArtista(String artista);
	
	public List<Seguro> getByPlaylistNombre(String nombre);
}

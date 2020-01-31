package com.ocaso.seguros.persistencia.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.ocaso.seguros.modelo.Seguro;
import com.ocaso.seguros.persistencia.dao.SeguroDAO;
import com.ocaso.seguros.persistencia.jpa.Utilidades;

public class SeguroDAOImplJpa extends GenericDAOImplJpa<Seguro,Integer> implements SeguroDAO {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findNifNombre() {
		EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();
		List<Object[]> lista =  (List<Object[]>) em.createQuery(
				"select S.nombre,S.nif " +
				"from Seguro S " 
				)
				.getResultList()
			;
		
		return lista;
	}
	
	@Override
	public Seguro findByName(String nombre, String apellido1, String apellido2) {
		EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();
		Seguro seguro =  (Seguro) em.createQuery(
				"select S " +
				"from Seguro S " +
				"where S.nombre like :nombre and S.ape1 like :ape1 and S.ape2 like :ape2 " )
			.setParameter( "nombre", nombre)
			.setParameter("ape1", apellido1)
			.setParameter("ape2", apellido2)
			.getSingleResult();
		return seguro;
	}
}

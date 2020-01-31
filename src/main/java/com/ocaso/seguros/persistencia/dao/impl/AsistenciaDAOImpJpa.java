package com.ocaso.seguros.persistencia.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.ocaso.seguros.modelo.Asistencia;
import com.ocaso.seguros.persistencia.dao.AsistenciaDAO;
import com.ocaso.seguros.persistencia.jpa.Utilidades;


public class AsistenciaDAOImpJpa extends GenericDAOImplJpa<Asistencia,Integer> implements AsistenciaDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Asistencia> findImporteMayor(BigDecimal decimal) {
		EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();
		List<Asistencia> lista =  (List<Asistencia>) em.createQuery(
				"select A " +
				"from Asistencia A "+
				" where A.importe >= :decimal")
				.setParameter("decimal", decimal)
				.getResultList()
			;
		return lista;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Asistencia> findImporteEntre(BigDecimal menor, BigDecimal mayor) {
		EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();
		List<Asistencia> lista = (List<Asistencia>) em.createQuery(
				"select A " +
				"from Asistencia A "+
				" where A.importe >= :menor and A.importe <=:mayor")
				.setParameter("menor", menor)
				.setParameter("mayor", mayor)
				.getResultList()
			;
		return lista;
		
	}
	
	

	
	
}

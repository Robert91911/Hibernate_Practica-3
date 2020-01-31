package com.ocaso.seguros.controlador;

import java.util.List;

import com.ocaso.seguros.modelo.Seguro;
import com.ocaso.seguros.persistencia.dao.SeguroDAO;
import com.ocaso.seguros.persistencia.dao.impl.SeguroDAOImplJpa;

public class SeguroController {

	SeguroDAO seguroDAO;
	
	public SeguroController() {
		seguroDAO = new SeguroDAOImplJpa();
	}
	
	public void mostrarSeguros() {
		List<Seguro> seguros = seguroDAO.findAll();
		
		for(Seguro seguro: seguros) {
			System.out.println(seguro.toString());
			
		}
		
	}
	
	public void mostrarNifNombres() {
		List<Object[]> seguros = seguroDAO.findNifNombre();
		
		for(Object[] seguro: seguros) {
			System.out.println("Nombre: "+ seguro[0] + ", NIF: " + seguro[1]);
			
		}
	}
	
	public void mostrarNIFporNombres() {
		Seguro seguro = seguroDAO.findByName("Maria", "Garcia", "Lozano");
		System.out.println("NIF: " + seguro.getNif());
	}
	
	public void mostrarNumeroSeguros() {
	  	Long i = seguroDAO.findNumeroSeguros();
    	System.out.println("Numero de seguros: " +i);
	}
	
	public void mostrarNIFyAsistencias() {
    	List<Object[]> lista= seguroDAO.findNIFyAsistencias();
    	for(Object[] o : lista) {
    		System.out.println("Nombre seguro: " + o[0]);
    		System.out.println("Nif: " + o[1]);
    		System.out.println("Nº Asistencias: " + o[2]);
    		
    	}
	}
}

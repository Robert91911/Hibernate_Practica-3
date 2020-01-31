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
}

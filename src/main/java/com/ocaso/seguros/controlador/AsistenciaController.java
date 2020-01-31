package com.ocaso.seguros.controlador;

import java.math.BigDecimal;
import java.util.List;

import com.ocaso.seguros.modelo.Asistencia;
import com.ocaso.seguros.persistencia.dao.AsistenciaDAO;
import com.ocaso.seguros.persistencia.dao.impl.AsistenciaDAOImpJpa;

public class AsistenciaController {
	
	AsistenciaDAO asistenciaDAO;
	
	public AsistenciaController() {
		asistenciaDAO = new AsistenciaDAOImpJpa();
	}
	
	public void mostrarAsistenciaSuperiorA() {
	  	List<Asistencia> asistencias = asistenciaDAO.findImporteMayor(new BigDecimal(10000));
    	for (Asistencia a: asistencias) {
			System.out.println("idAsistenciaMedica: " + a.getId());
		}
	}
	
	public void mostrarAsistenciaEntre() {
		List<Asistencia> asistencias = asistenciaDAO.findImporteEntre(new BigDecimal(8000), new BigDecimal(15000));
    	for (Asistencia a: asistencias) {
			System.out.println("idAsistenciaMedica: " + a.getId());
    	}
	}
	
	public void mostrarSumaImportes() {
		BigDecimal b = asistenciaDAO.findSumaImportes();
    	System.out.println("Suma de los importes: " + b);
	}
	
	public void mostrarSaldoMedio() {
    	double b = asistenciaDAO.findSaldoMedio();
    	System.out.println("Media del saldo" + b);
	}
}
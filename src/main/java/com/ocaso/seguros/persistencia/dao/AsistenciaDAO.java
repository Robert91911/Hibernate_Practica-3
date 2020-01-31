package com.ocaso.seguros.persistencia.dao;


import java.math.BigDecimal;
import java.util.List;

import com.ocaso.seguros.modelo.Asistencia;

public interface AsistenciaDAO extends GenericDAO<Asistencia, Integer> {
	public List<Asistencia> findImporteMayor(BigDecimal decimal);
	public List<Asistencia> findImporteEntre(BigDecimal menor,BigDecimal mayor);
	public BigDecimal findSumaImportes();
	public double findSaldoMedio();
	
}

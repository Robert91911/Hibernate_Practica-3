package com.ocaso.seguros;

import javax.persistence.EntityManager;

import com.ocaso.seguros.controlador.SeguroController;
import com.ocaso.seguros.persistencia.jpa.Utilidades;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        EntityManager em = null;

        try {
            em = Utilidades.getEntityManagerFactory().createEntityManager();
            SeguroController sc = new SeguroController();
//            AsistenciaController ac = new AsistenciaController();
            SeguroController seguro = new SeguroController();
            seguro.mostrarSeguros();
        } catch (Exception e) {
            if (em != null) {
                System.out.println("Se va a hacer rollback de la transacción");
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        Utilidades.closeEntityManagerFactory();
    }
}

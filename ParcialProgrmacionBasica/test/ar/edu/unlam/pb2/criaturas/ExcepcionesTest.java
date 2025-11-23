package ar.edu.unlam.pb2.criaturas;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExcepcionesTest {

	@Test
	public void testEnergiaDesbordada() {
	    Criatura criatura = new Salvaje("Rok", 190, AfinidadElemental.FUEGO, Comportamiento.TRANQUILA);
	    try {
	        criatura.entrenar(); 
	    } catch (EnergiaDesbordadaException e) {
	        assertEquals("La criatura salvaje excedió el límite de energía permitido.", e.getMessage());
	    }
	}

}
